package com.yang.servicebase.exceptionhandler;

import com.yang.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: csy
 * @Date: 2020/11/1 21:43
 * @Description: 定义全局异常类
 */
@ControllerAdvice
@Slf4j
public class  GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        log.error(e.getMessage());
        return R.error().message("全局异常处理");
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){
        e.printStackTrace();
        log.error(e.getMessage());
        return R.error().message("执行了ArithmeticException异常处理");
    }

    @ExceptionHandler(ErpException.class)
    @ResponseBody
    public R error(ErpException e){
        e.printStackTrace();
        log.error(e.getMessage());
        return R.error().message("执行了ErpException异常处理");
    }
}
