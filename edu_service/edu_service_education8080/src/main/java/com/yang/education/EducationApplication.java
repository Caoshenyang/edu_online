package com.yang.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: csy
 * @Date: 2020/10/29 20:47
 * @Description: 启动类
 */
@SpringBootApplication
@RestController
public class EducationApplication {

    public static void main(String[] args) {
        SpringApplication.run(EducationApplication.class,args);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "redirct:http://localhost:8080/swagger-ui.html";
    }
}
