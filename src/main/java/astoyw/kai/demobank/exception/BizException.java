package astoyw.kai.demobank.exception;


import astoyw.kai.demobank.common.enums.BizCodeEnum;
import lombok.Data;

/**
 * 自定义全局异常
 */
@Data
public class BizException extends RuntimeException {

    private int code;
    private String msg;
    public BizException(int code,String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }
    public BizException(BizCodeEnum bizCodeEnum){
        super(bizCodeEnum.getMessage());
        this.code = bizCodeEnum.getCode();
        this.msg = bizCodeEnum.getMessage();
    }
}
