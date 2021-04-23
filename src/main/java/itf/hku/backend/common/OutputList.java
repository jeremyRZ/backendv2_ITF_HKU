package itf.hku.backend.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: 出参对象
 * @Author: zsj
 * @CreateDate: 2019/8/16 19:43
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutputList implements Serializable {

    /**
     * 响应码
     */
    private String respCode;
    /**
     * 响应信息
     */
    private String respMessage;
    /**
     * 响应数据
     */
    private List data;

    /**
     * toString
     *
     * @return
     */
    @Override
    public String toString() {
        return "OutputObject{" +
                "respCode='" + respCode + '\'' +
                ", respMessage='" + respMessage + '\'' +
                ", data=" + data +
                '}';
    }
}

