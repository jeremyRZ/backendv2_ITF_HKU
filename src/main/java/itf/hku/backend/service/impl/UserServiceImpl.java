package itf.hku.backend.service.impl;

import itf.hku.backend.entity.User;
import itf.hku.backend.mapper.UserMapper;
import itf.hku.backend.pojo.UserKmmy;
import itf.hku.backend.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JeremyZhao
 * @since 2021-04-20
 */
//@Service
//public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
//
//}


/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 朱少杰
 * @since 2020-06-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserKmmy> implements UserService {

}
