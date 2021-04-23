package itf.hku.backend.controller;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import itf.hku.backend.common.OutputObject;
import itf.hku.backend.common.ReturnCode;
import itf.hku.backend.entity.Material;
import itf.hku.backend.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author JeremyZhao
 * @since 2021-04-20
 */
@Controller
@RequestMapping("api/material")
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @PostMapping("upload")
    @ResponseBody
    public OutputObject handleFileUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file, Material material) throws IOException {

            MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
            List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                    .getFiles("file");
            String anturalLng = params.getParameter("acturallng");
            String elementMark = params.getParameter("elementmark");
            String remark = params.getParameter("remark");
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            //上传文件存储的位置
            String destFileName = "E:\\data\\WCH\\uploadfile" + File.separator + fileName;
            //防止改文件夹不存在，创建一个新文件夹
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            //将文件存储到该位置
            file.transferTo(destFile);
            //将文件名存储到数据库中，以便查询调用
            material.setPicname(fileName);
            material.setActurallng(anturalLng);
            material.setElementmark(elementMark);
            material.setRemark(remark);
            materialService.save(material);
            //Show data for return
            HashMap<String,Object> hs =new HashMap<>();
            hs.put("filePath",destFile);
            hs.put("fileName",fileName);
        return new OutputObject (ReturnCode.SUCCESS,"Operation Success",hs);
    }
}

