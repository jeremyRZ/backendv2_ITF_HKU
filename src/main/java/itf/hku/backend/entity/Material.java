package itf.hku.backend.entity;

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
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("elementMark")
    private String elementmark;

    @TableField("acturalLng")
    private String acturallng;

    private String remark;

    /**
     *
     */
    @TableField("picPath")
    private String picpath;

}
