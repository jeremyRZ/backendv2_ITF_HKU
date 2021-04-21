package itf.hku.backend.mapper;
import itf.hku.backend.pojo.UserKmmy;
import org.apache.ibatis.annotations.Param;

import itf.hku.backend.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author JeremyZhao
 * @since 2021-04-20
 */
//public interface UserMapper extends BaseMapper<User> {
//    static User insertSelective(User user){
//        insertSelective(user);
//        return user;
//    }
//
//
//}

public interface UserMapper extends BaseMapper<UserKmmy> {

}
