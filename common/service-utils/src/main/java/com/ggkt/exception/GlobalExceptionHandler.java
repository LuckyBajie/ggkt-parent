package com.ggkt.exception;

import com.ggkt.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        log.error("全局异常捕获：", e);
        return Result.fail(e).message("执行了全局异常处理");
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e){
        log.error("特定异常处理：", e);

        return Result.fail(null).message("执行了特定异常处理");
    }

    @ExceptionHandler(GgktException.class)
    @ResponseBody
    public Result error(GgktException e){
        log.error("自定义异常处理：", e);
        return Result.fail(null).message(e.getMsg()).code(e.getCode());
    }
}
