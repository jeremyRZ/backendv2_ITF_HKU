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
public class TaskUiMaterials implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("elementType")
    private String elementtype;

    @TableField("elementUIParams")
    private String elementuiparams;


}
