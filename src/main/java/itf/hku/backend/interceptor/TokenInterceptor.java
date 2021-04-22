package itf.hku.backend.interceptor;

import com.alibaba.fastjson.JSONObject;
import itf.hku.backend.annotation.LoginRequired;
import itf.hku.backend.common.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 判断接口是否需要登录
        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);
        // 有 @LoginRequired 注解，需要认证
        if (methodAnnotation != null) {
            if(request.getMethod().equals("OPTIONS")){
                response.setStatus(HttpServletResponse.SC_OK);
                return true;
            }
            response.setCharacterEncoding("utf-8");
            String token = request.getHeader("token");
            if(token != null){
                boolean result = TokenUtil.verify(token);
                if(result){
                    System.out.println("通过拦截器");
                    return true;
                }
            }
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            try{
                JSONObject json = new JSONObject();
                json.put("msg","token verify fail");
                json.put("code","50000");
                response.getWriter().append(json.toJSONString());
                System.out.println("认证失败，未通过拦截器");
            }catch (Exception e){
                e.printStackTrace();
                response.sendError(500);
                return false;
            }
        }
        return false;
    }
}
