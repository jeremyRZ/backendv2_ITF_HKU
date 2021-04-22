package itf.hku.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 朱少杰
 * @since 2020-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户ID 绝对唯一
     */
    @TableId(value = "userid", type = IdType.AUTO)
    private Long userid;

    /**
     * 用户名
     */
    private String uname;

    /**
     * 密码
     */
    private String passwd;

    /**
     * 用户职位
     */
    private String post;

    /**
     * 用户邮箱
     */
    @TableField("emailAddress")
    private String emailaddress;

    /**
     * 用户手机
     */
    @TableField("cellNumber")
    private String cellnumber;

    /**
     * 是否激活
     */
    private Boolean isactive;

    /**
     * 加密盐值
     */
    private String salt;

    /**
     * 用户头像
     */
    private String headImg;

    /**
     * 禁用账号 : 0 正常 , 1 禁用
     */
    private Integer locked;

    /**
     * 账号创建时间
     */
    private Date createTime;

    /**
     * 用户最后登陆时间
     */
    private Date lastLoginTime;

    /**
     * 管理员更新用户状态的时间
     */
    private Date updateTime;


    public User(String uname, String passwd) {
        this.uname = uname;
        this.passwd = passwd;
    }
}
