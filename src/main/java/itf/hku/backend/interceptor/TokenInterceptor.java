package itf.hku.backend.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import itf.hku.backend.annotation.LoginRequired;
import itf.hku.backend.common.TokenUtil;
import itf.hku.backend.entity.TaskUi;
import itf.hku.backend.entity.User;
import itf.hku.backend.entity.UserProj;
import itf.hku.backend.mapper.UserProjMapper;
import itf.hku.backend.service.UserProjService;
import itf.hku.backend.service.UserService;
import itf.hku.backend.service.impl.UserProjServiceImpl;
import itf.hku.backend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private UserServiceImpl userService;

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 判断接口是否需要登录
        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);
        // 有 @LoginRequired 注解，需要认证
        System.out.println("useruseruser1");
        if (methodAnnotation != null) {
            // 执行认证
            String token = request.getHeader("token");  // 从 http 请求头中取出 token
            if (token == null) {
                throw new RuntimeException("无token，请重新登录");
            }
            System.out.println("useruseruser");
            int userId;
            try {
                userId = Integer.parseInt(JWT.decode(token).getAudience().get(0));  // 获取 token 中的 user id
            } catch (JWTDecodeException e) {
                throw new RuntimeException("token无效，请重新登录");
            }
            User user = userService.getById(userId);
            if (user == null) {
                throw new RuntimeException("用户不存在，请重新登录");
            }
            // 验证 token
            JWTVerifier verifier =  JWT.require(Algorithm.HMAC256(user.getPasswd())).build();
            try {
                verifier.verify(token);
            } catch (JWTVerificationException e) {
                throw new RuntimeException("token无效，请重新登录");
            }
            request.setAttribute("currentUser", user);
            return true;
        }
        return true;
    }
}
