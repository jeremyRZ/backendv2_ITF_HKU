package itf.hku.backend.entity;

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
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ModuleNo")
    private String moduleno;

    @TableField("ModuleName")
    private String modulename;


}
