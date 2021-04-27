package itf.hku.backend.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import itf.hku.backend.common.OutputList;
import itf.hku.backend.common.OutputObject;
import itf.hku.backend.common.ReturnCode;
import itf.hku.backend.entity.TaskUi;
import itf.hku.backend.entity.UnitsManu;
import itf.hku.backend.service.UnitsManuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author JeremyZhao
 * @since 2021-04-26
 */
@Controller
@RequestMapping("api/unitsManu")
public class UnitsManuController {
    @Autowired
    private UnitsManuService unitsManuService;

    @PostMapping("getUnit")
    @ResponseBody
    public OutputList genReport(@RequestBody UnitsManu unitsManu){
        QueryWrapper<UnitsManu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("unitID",unitsManu.getUnitID())
                .eq("moduleID",unitsManu.getModuleID());
        List<UnitsManu> unitsManuList = unitsManuService.list(queryWrapper);
        return new OutputList(ReturnCode.SUCCESS,"Query Units Data Success",unitsManuList);
    }
}