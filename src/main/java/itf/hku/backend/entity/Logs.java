package itf.hku.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author JeremyZhao
 * @since 2021-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Logs implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("projID")
    private String projid;

    private LocalDateTime timestamp;

    @TableField("clientIP")
    private String clientip;

    private String event;

    @TableField("requestHeader")
    private String requestheader;

    @TableField("reqestBody")
    private String reqestbody;

    @TableField("requestSQL")
    private String requestsql;


}
