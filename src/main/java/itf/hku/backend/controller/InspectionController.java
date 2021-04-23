package itf.hku.backend.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import itf.hku.backend.common.*;
import itf.hku.backend.entity.Inspection;
import itf.hku.backend.entity.TaskUi;
import itf.hku.backend.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
@RequestMapping("/api/inspection")
public class InspectionController {
    @Autowired
    private InspectionService inspectionService;

    @PostMapping("addInspData")
    @ResponseBody
    public ResultObj addInspData(@RequestBody Inspection inspection) {
        try {
            QueryWrapper<Inspection> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("moduleID",inspection.getModuleid());
            inspectionService.save(inspection);
            return ResultObj.QUERY_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.QUERY_ERROR;
        }
    }

    @GetMapping("genReport")
    @ResponseBody
    public OutputList genReport(@RequestBody Inspection inspection){
        QueryWrapper<Inspection> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("taskID",inspection.getTaskid())
                    .eq("moduleID",inspection.getModuleid());
        List<Inspection> inspecList = inspectionService.list(queryWrapper);
        return new OutputList(ReturnCode.SUCCESS,"Query Inspection Data Success",inspecList);
    }
}

