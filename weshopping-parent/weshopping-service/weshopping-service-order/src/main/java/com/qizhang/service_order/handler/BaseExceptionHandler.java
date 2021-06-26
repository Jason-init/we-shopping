package com.qizhang.service_order.handler;

import com.qizhang.common.pojo.Result;
import com.qizhang.common.pojo.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 */
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<Void> error(Exception e) {
        e.printStackTrace();
        return new Result<>(false, StatusCode.ERROR, "当前系统繁忙，请您稍后再试");
    }
}
