package itf.hku.backend.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import itf.hku.backend.entity.UserProj;
import itf.hku.backend.mapper.UserProjMapper;
import itf.hku.backend.service.UserProjService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author JeremyZhao
 * @since 2021-04-27
 */
@Service
public class UserProjServiceImpl extends ServiceImpl<UserProjMapper, UserProj> implements UserProjService {


    public static String getToken(UserProj userProj) {
        String token = "";
        token = JWT.create()
                .withAudience(userProj.getUserid().toString())          // 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(userProj.getPasswd()));   // 以 password 作为 token 的密钥
        return token;
    }

}
