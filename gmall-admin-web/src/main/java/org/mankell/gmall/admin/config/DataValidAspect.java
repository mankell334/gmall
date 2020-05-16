package org.mankell.gmall.admin.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.mankell.gmall.to.CommonResult;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Aspect
@Component
public class DataValidAspect {

    /**
     * 数据校验环绕通知
     *
     * @param point
     * @return
     */
    @Around("execution(* org.mankell.gmall.admin..*Controller.*(..))")
    public Object validAround(ProceedingJoinPoint point) {
        Object proceed;
        try {
            Object[] args = point.getArgs();
            for (Object o : args) {
                if (o instanceof BindingResult) {
                    BindingResult result = (BindingResult) o;
                    int errorCount = result.getErrorCount();
                    if (errorCount > 0) {
                        return new CommonResult().validateFailed(result);
                    }
                }
            }
            // 执行目标方法
            proceed = point.proceed(point.getArgs());
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
        return proceed;
    }
}
