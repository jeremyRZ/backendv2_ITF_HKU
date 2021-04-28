package itf.hku.backend.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import itf.hku.backend.annotation.CurrentUser;
import itf.hku.backend.annotation.LoginRequired;
import itf.hku.backend.common.MD5Utils;
import itf.hku.backend.common.OutputObject;
import itf.hku.backend.common.ReturnCode;
import itf.hku.backend.common.TokenUtil;
import itf.hku.backend.entity.User;
import itf.hku.backend.entity.UserProj;
import itf.hku.backend.service.UserProjService;
import itf.hku.backend.service.UserService;
import itf.hku.backend.service.impl.UserProjServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;

/**
 * <p>
 * VIEW 前端控制器
 * </p>
 *
 * @author JeremyZhao
 * @since 2021-04-27
 */
@Controller
@RequestMapping("api/userProj")
public class UserProjController {
    @Autowired
    private UserProjService userProjService;

    @PostMapping("login")
    @ResponseBody
    public OutputObject login(@RequestBody UserProj userProj){
        QueryWrapper<UserProj> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(userProj.getUname() != null, "uname", userProj.getUname());
        UserProj users = userProjService.getOne(queryWrapper);

        // 密码校验
        String s = (MD5Utils.md5(userProj.getPasswd()+users.getSalt()));
        if (users.getPasswd().equals(s)==false){
            return new OutputObject(ReturnCode.FAIL,"密码不正确",userProj);
        }
        queryWrapper.in(userProj.getPasswd() != null, "passwd", s);
        // 通过用户名从数据库中查询出该用户
        if (users == null){
            return new OutputObject(ReturnCode.FAIL,"用户不存在",userProj);
        }
        String token = UserProjServiceImpl.getToken(users);

        HashMap<String,Object> hs =new HashMap<>();
        hs.put("token",token);
        hs.put("userid",users.getUserid());
        hs.put("activeProj",users.getActiveProj());
        hs.put("appUIVersion",users.getAppuiVer());
        return new OutputObject(ReturnCode.SUCCESS,"Login Success",hs);
    }
}

