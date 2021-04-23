package itf.hku.backend.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import itf.hku.backend.common.OutputObject;
import itf.hku.backend.common.ReturnCode;
import itf.hku.backend.entity.TaskUi;
import itf.hku.backend.entity.User;
import itf.hku.backend.service.TaskUiService;
import itf.hku.backend.service.impl.TaskUiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author JeremyZhao
 * @since 2021-04-20
 */
@RestController
@RequestMapping("api/taskUi")
public class TaskUiController {

    @Autowired
    private TaskUiService taskUiService;

    @PostMapping("get")
    @ResponseBody
    public OutputObject queryTaskui(@RequestBody TaskUi taskUi){
        QueryWrapper<TaskUi> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("taskType", taskUi.getTasktype())
                    .eq("moduleType",taskUi.getModuletype());
        TaskUi returnResult = taskUiService.getOne(queryWrapper);
        HashMap<String,Object> hs =new HashMap<>();
        hs.put("id",returnResult.getId());
        hs.put("projID",returnResult.getProjid());
        hs.put("moduleType",returnResult.getModuletype());
        hs.put("taskType",returnResult.getTasktype());
        hs.put("taskItem",returnResult.getTaskitem());
        hs.put("taskUIParams",returnResult.getTaskuiparams());
        hs.put("taskDescEn",returnResult.getTaskdescen());
        hs.put("taskDescCn",returnResult.getTaskdesccn());
        hs.put("taskDay",returnResult.getTaskday());
        hs.put("inspTestMethod",returnResult.getInsptestmethod());
        hs.put("reinspRetest",returnResult.getReinspretest());
        hs.put("responsibilty",returnResult.getResponsibilty());
        hs.put("ordering",returnResult.getOrdering());
//        return new OutputObject(String.valueOf(HttpStatus.OK.value()),"Login Success",hs);
        return new OutputObject(ReturnCode.SUCCESS,"Query TaskUI Data Success",hs);
    }
}

