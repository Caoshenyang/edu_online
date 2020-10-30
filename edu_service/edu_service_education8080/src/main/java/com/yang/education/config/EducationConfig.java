package com.yang.education.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
/**
 * @Author: csy
 * @Date: 2020/10/29 21:01
 * @Description: 配置类
 */
@Configuration
@MapperScan("com.yang.education.mapper")
public class EducationConfig {



}
