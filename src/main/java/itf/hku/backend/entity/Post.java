package itf.hku.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer authorId;

    private String title;

    private String content;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
