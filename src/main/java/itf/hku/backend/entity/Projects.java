package itf.hku.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Projects implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("projID")
    private String projid;

    @TableField("projNameCn")
    private String projnamecn;

    @TableField("projNameEn")
    private String projnameen;

    @TableField("numTasks")
    private Integer numtasks;

    @TableField("withBlockchain")
    private Integer withblockchain;

    @TableField("maincontractorID")
    private String maincontractorid;

    @TableField("clientID")
    private String clientid;

    @TableField("manufacturerID")
    private String manufacturerid;

    private Integer batchId;

    private String unitId;


}
