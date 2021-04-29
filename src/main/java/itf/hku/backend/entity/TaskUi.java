package itf.hku.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
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
@TableName(autoResultMap=true)
public class TaskUi implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("projID")
    private String projid;

    @TableField("moduleType")
    private String moduletype;

    @TableField("taskType")
    private String tasktype;

    @TableField("taskItem")
    private Integer taskitem;

    @TableField(value = "taskUIParams", typeHandler= FastjsonTypeHandler.class)
    private List taskuiparams;

    @TableField("taskDescEn")
    private String taskdescen;

    @TableField("taskDescCn")
    private String taskdesccn;

    @TableField("taskDay")
    private Integer taskday;

    @TableField("inspTestMethod")
    private String insptestmethod;

    @TableField("reinspRetest")
    private String reinspretest;

    private String responsibilty;

    private Integer ordering;

    private Integer disabled;

}
