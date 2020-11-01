package com.yang.education.controller;


import com.yang.education.entity.Teacher;
import com.yang.education.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author caoshenyang
 * @since 2020-10-29
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/education/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * @Author: csy
     * @Date: 2020/10/29 22:05
     * @Description: 查询所有讲师
     * @Param: []
     * @Return: java.util.List<com.yang.education.entity.Teacher>
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Teacher> findAllTeachers() {
        List<Teacher> list = teacherService.list();
        return list;
    }

    @ApiOperation(value = "逻辑删除讲师")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public boolean removeTeacher(
            @ApiParam(name = "id", value = "讲师Id", required = true)
            @PathVariable String id) {
        boolean b = teacherService.removeById(id);
        return b;
    }


}

