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
import java.util.*;
import java.util.stream.Collectors;

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
    @PostMapping("getModuleListByStep")
    @ResponseBody
    public OutputList queryModuleListByType(){
        QueryWrapper<TaskUi> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("projID","moduleType","taskItem","taskDescEn","taskDescCn","count(*) as numTasks")
                    .groupBy("moduleType","taskItem")
                    .lt("disabled",1)
                    .orderByAsc("projID","moduleType","taskItem");

        List<Map<String, Object>> ParentList = taskUiService.listMaps(queryWrapper);


        QueryWrapper<TaskUi> subqueryWrapper = new QueryWrapper<>();
        subqueryWrapper.select("taskType","taskUIParams","taskDay","taskItem","inspTestMethod","reinspRetest","responsibilty","ordering","moduleType");
        List<Map<String, Object>> SubList = taskUiService.listMaps(subqueryWrapper);

        //// List all data
        for (int i = 1; i < SubList.size(); i++) {
            int finalI = i;
            List<Map<String, Object>> result = SubList.stream()
                    .filter(m -> ((Integer) m.get("taskItem")) == finalI)
                    .collect(Collectors.toList());

            for (int j = 0; j < result.size(); j++) {
                String moduletype = String.valueOf(result.get(j).toString());
                String[] arr = moduletype.split(",");
                List<String> al = new ArrayList<String>();
                al = Arrays.asList(arr);
                List<String> finalAl = al;
                ParentList.forEach(map -> {
                    String mapmodule = (String) map.get("moduleType");
                    if (map.get("taskItem").equals(finalI) && finalAl.get(2).contains(mapmodule)){
                        List<Map<String, Object>> finaresule = result.stream()
                                .filter(t -> ((String) t.get("moduleType")).equals(mapmodule))
                                .collect(Collectors.toList());
                        map.put("children",finaresule);
                    }
                });
            }
        }
        return new OutputList(ReturnCode.SUCCESS,"Query TaskUI Data Success",ParentList);
    }
}

