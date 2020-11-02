package com.yang.servicebase.exceptionhandler;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: csy
 * @Date: 2020/11/2 20:34
 * @Description: 自定义异常
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErpException extends RuntimeException{

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "异常信息")
    private String msg;
}
