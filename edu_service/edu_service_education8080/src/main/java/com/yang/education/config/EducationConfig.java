package com.yang.education.config;

/**
 * @Author: csy
 * @Date: 2020/10/29 21:01
 * @Description: 配置类
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.yang.education.mapper")
public class EducationConfig {



}
