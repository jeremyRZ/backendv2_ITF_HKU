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
public class Inspection implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("moduleID")
    private String moduleid;

    private String floor;

    @TableField("drawingID")
    private Integer drawingid;

    @TableField("taskID")
    private Integer taskid;

    @TableField("targetID")
    private String targetid;

    private LocalDateTime timestamp;

    @TableField("inspValues")
    private String inspvalues;

    @TableField("userID")
    private String userid;

    @TableField("companyID")
    private String companyid;


}
