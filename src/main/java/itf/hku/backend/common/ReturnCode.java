package itf.hku.backend.common;

/**
 * 响应码
 *
 * @author zhushaojie
 */
public class ReturnCode {

    /**
     * 成功
     */
    public static final String SUCCESS = "success";

    /**
     * 失败
     */
    public static final String FAIL = "fail";

    /**
     * 未签证
     */
    public static final String UNAUTHORIZED = "UNAUTHORIZED";

    /**
     * 未找到接口
     */
    public static final String NOT_FOUND = "NOT_FOUND";

    /**
     * 服务器内部错误
     */
    public static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";

    /**
     * 用户默认图片
     */
    public static final String DEFAULT_IMG_USER = "/images/defaultUserTitle.jpg";

}
