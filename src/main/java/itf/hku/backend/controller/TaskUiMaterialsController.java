package itf.hku.backend.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import itf.hku.backend.common.OutputList;
import itf.hku.backend.common.ReturnCode;
import itf.hku.backend.entity.TaskUi;
import itf.hku.backend.entity.TaskUiMaterials;
import itf.hku.backend.service.TaskUiMaterialsService;
import itf.hku.backend.service.TaskUiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("api/taskUiMaterials")
public class TaskUiMaterialsController {
    @Autowired
    private TaskUiMaterialsService taskUiMaterialsService;

    @GetMapping("getMaterialsList")
    @ResponseBody
    public OutputList queryMaterialsList(){
//        QueryWrapper<TaskUiMaterials> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("moduleType",taskUiMaterials.getId());
        List<TaskUiMaterials> taskUiList = taskUiMaterialsService.list();
        return new OutputList(ReturnCode.SUCCESS,"Query TaskUI Data Success",taskUiList);
    }
}

