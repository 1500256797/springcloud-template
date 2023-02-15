package cn.xxx.order.exception;


import cn.xxx.order.dto.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**统一异常处理类
 * @author:梁志杰
 * @date:2022/4/12
 * @description:cn.xueden.exception
 * @version:1.0
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public BaseResult error(BadRequestException e){
        e.printStackTrace();
        log.error(ThrowableUtil.getStackTrace(e));
        return BaseResult.fail(e.getMessage(),e.getStatus());
    }

}
