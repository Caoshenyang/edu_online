package com.yang.education;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Author: csy
 * @Date: 2020/10/29 20:47
 * @Description: 启动类
 */
@SpringBootApplication
@RequestMapping
@ComponentScan(basePackages = "com.yang")
public class EducationApplication {

    public static void main(String[] args) {
        SpringApplication.run(EducationApplication.class,args);
    }

    @ApiIgnore
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "redirect:http://localhost:8080/swagger-ui.html";
    }
}
