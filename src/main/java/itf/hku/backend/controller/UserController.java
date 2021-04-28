package itf.hku.backend.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import itf.hku.backend.annotation.CurrentUser;
import itf.hku.backend.annotation.LoginRequired;
import itf.hku.backend.common.*;
import itf.hku.backend.entity.User;
import itf.hku.backend.entity.UserProj;
import itf.hku.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author JeremyZhao
 * @since 2021-04-20
 */
/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 朱少杰
 * @since 2020-06-04
 */

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

/**
*
* Move to UserController for Login
*
 */
//    @PostMapping("login")
//    @ResponseBody
//    public OutputObject login(@RequestBody User user){
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq(user.getUname() != null, "uname", user.getUname());
//        User users = userService.getOne(queryWrapper);
//
//        // 密码校验
//        String s = (MD5Utils.md5(user.getPasswd()+users.getSalt()));
//
//        System.out.println(s);
//        System.out.println("111111111111111");
//        System.out.println(users.getPasswd());
//        if (users.getPasswd().equals(s)==false){
//            return new OutputObject(ReturnCode.FAIL,"密码不正确",user);
//        }
//        queryWrapper.in(user.getPasswd() != null, "passwd", s);
//        // 通过用户名从数据库中查询出该用户
//        if (users == null){
//            return new OutputObject(ReturnCode.FAIL,"用户不存在",user);
//        }
//        String token = TokenUtil.sign(new User(user.getUname(),s));
//        HashMap<String,Object> hs =new HashMap<>();
//        hs.put("token",token);
//        hs.put("userid",users.getUserid());
////        return new OutputObject(String.valueOf(HttpStatus.OK.value()),"Login Success",hs);
//        return new OutputObject(ReturnCode.SUCCESS,"Login Success",hs);
//    }

    /**
     * 用户注册
     * @param user
     * @return
     */

    @PostMapping("addUser")
    @ResponseBody
    public ResultObj addUser(@RequestBody User user) {
        try {
            // 查询用户名是否存在
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("uname",user.getUname());
            User users = userService.getOne(queryWrapper);
            if (users!=null){
                return ResultObj.THE_USER_ALREADY_EXISTS;
            }
            // 设置盐
            String salt = UUIDUtils.getUUID();
            user.setSalt(salt);
            // 设置密码加密
            String s = MD5Utils.md5(user.getPasswd()+salt);
            // 设置用户默认头像
            user.setPasswd(s);
            user.setHeadImg(ReturnCode.DEFAULT_IMG_USER);
            userService.save(user);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public ResultObj updateUser(@RequestBody User user) {
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("uname", user.getUname());
            userService.update(user,queryWrapper);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
    @GetMapping("/getdata") //get information aboout user
    @LoginRequired
    public Object testCurrentUser(@CurrentUser User user) {
        return user;
    }
}

