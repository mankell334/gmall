package org.mankell.gmall.admin.config;

import lombok.extern.slf4j.Slf4j;
import org.mankell.gmall.to.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public Object handlerException(Exception e) {
        log.error("系统全局感知异常，信息：{}", e.getMessage());
        return new CommonResult().validateFailed(e.getMessage());
    }
}
