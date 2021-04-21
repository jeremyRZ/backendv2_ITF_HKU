package itf.hku.backend.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import itf.hku.backend.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import itf.hku.backend.pojo.UserKmmy;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author JeremyZhao
 * @since 2021-04-20
 */
//public interface UserService extends IService<User> {
//
//
//}


/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 朱少杰
 * @since 2020-06-04
 */
public interface UserService extends IService<UserKmmy> {

}
