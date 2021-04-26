package itf.hku.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author JeremyZhao
 * @since 2021-04-26
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class UnitsManu implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    @TableField("unitID")
    private String unitID;

    @TableField("moduleID")
    private String moduleID;

    private String type;

    private String floor;

    private Integer progress;

    @TableField("plannedStart")
    private LocalDateTime plannedStart;

    @TableField("plannedManufactured")
    private LocalDateTime plannedManufactured;

    @TableField("plannedDelivery")
    private LocalDateTime plannedDelivery;

    @TableField("plannedInstall")
    private LocalDateTime plannedInstall;

    @TableField("actualStart")
    private LocalDateTime actualStart;

    @TableField("actualManufactured")
    private LocalDateTime actualManufactured;

    @TableField("actualDelivery")
    private LocalDateTime actualDelivery;

    @TableField("actualInstall")
    private LocalDateTime actualInstall;

    @TableField("inspTasks")
    private String inspTasks;


}
