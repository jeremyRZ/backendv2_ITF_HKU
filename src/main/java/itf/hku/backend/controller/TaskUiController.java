package itf.hku.backend.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import itf.hku.backend.common.OutputList;
import itf.hku.backend.common.OutputObject;
import itf.hku.backend.common.ReturnCode;
import itf.hku.backend.entity.TaskUi;
import itf.hku.backend.entity.User;
import itf.hku.backend.service.TaskUiService;
import itf.hku.backend.service.impl.TaskUiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.lang.reflect.Array;
import java.util.Arrays;
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
@RestController
@RequestMapping("api/taskUi")
public class TaskUiController {

    @Autowired
    private TaskUiService taskUiService;

    @GetMapping("getTaskDetail")
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
        return new OutputObject(ReturnCode.SUCCESS,"Query TaskUI Data Success",hs);
    }

    @PostMapping("getModuleList")
    @ResponseBody
    public OutputList queryModuleList(){
        QueryWrapper<TaskUi> queryWrapper = new QueryWrapper<>();
//        queryWrapper.groupBy("moduletype");
        List<TaskUi> taskUiList = taskUiService.list(queryWrapper);
        return new OutputList(ReturnCode.SUCCESS,"Query TaskUI Data Success",taskUiList);
    }
    //Todo use tree model
    @PostMapping("getModuleListByType")
    @ResponseBody
    public OutputList queryModuleListByType(){



        QueryWrapper<TaskUi> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("moduletype","Toilet");
        List<TaskUi> ToiletList = taskUiService.list(queryWrapper);

        QueryWrapper<TaskUi> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("moduleType","Hostel Room");
        List<TaskUi> HostList = taskUiService.list(queryWrapper2);

        System.out.println("1111111111111111");
        System.out.println(HostList);
        System.out.println("1111111111111111");
        System.out.println(ToiletList);
        return new OutputList(ReturnCode.SUCCESS,"Query TaskUI Data Success",HostList);
    }
}

