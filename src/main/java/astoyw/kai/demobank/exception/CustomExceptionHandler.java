package astoyw.kai.demobank.exception;


import astoyw.kai.demobank.tools.JsonData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData Handl(Exception e){

        //是否为自定义异常
        if(e instanceof BizException){
            BizException bizException = (BizException) e;
            log.error("[业务异常{}]",e);
            return JsonData.buildCodeAndMsg(bizException.getCode(), bizException.getMsg());
        }else {
            log.error("[系统异常{} ]",e);
            return JsonData.buildCodeAndMsg(-1,"全局异常");
        }
    }
}
