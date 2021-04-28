package itf.hku.backend.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author JeremyZhao
 * @since 2021-04-27
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class UserProj implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 用户ID 绝对唯一
     */
      private Integer userid;

      /**
     * 用户邮箱
     */
      @TableField("emailAddress")
    private String emailAddress;

      /**
     * 用户手机
     */
      @TableField("cellNumber")
    private String cellNumber;

      /**
     * 用户权限类型：0普通，1管理员
     */
      private String post;

      /**
     * 用户名
     */
      private String uname;

      /**
     * 密码
     */
      private String passwd;

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
      private LocalDateTime createTime;

      /**
     * 用户最后登陆时间
     */
      private LocalDateTime lastLoginTime;

      /**
     * 管理员更新用户状态的时间
     */
      private LocalDateTime updateTime;

    @TableField("activeProj")
    private String activeProj;

    @TableField("appuiVer")
    private String appuiVer;


}
