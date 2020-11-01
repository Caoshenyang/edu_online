package com.yang.education.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.commonutils.R;
import com.yang.education.entity.Teacher;
import com.yang.education.entity.vo.TeacherQuery;
import com.yang.education.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
    public R findAllTeachers() {
        List<Teacher> list = teacherService.list();
        return R.ok().data("items", list);
    }

    @ApiOperation(value = "逻辑删除讲师")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public R removeTeacher(
            @ApiParam(name = "id", value = "讲师Id", required = true)
            @PathVariable String id) {
        boolean b = teacherService.removeById(id);
        return b ? R.ok() : R.error();
    }

    @ApiOperation(value = "讲师分页查询")
    @GetMapping(value = "pageTeacher/{current}/{limit}")
    public R pageListTeachers(
            @ApiParam(name = "current", value = "当前页", required = true)
            @PathVariable Long current,
            @ApiParam(name = "limit", value = "每页显示几条", required = true)
            @PathVariable Long limit) {
        //创建page对象
        Page<Teacher> pageTeacher = new Page<>(current, limit);
        //调用方法实现分页
        teacherService.page(pageTeacher, null);
        long total = pageTeacher.getTotal();
        List<Teacher> records = pageTeacher.getRecords();
        return R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "分页条件查询")
    @PostMapping(value = "pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(
            @ApiParam(name = "current", value = "当前页", required = true)
            @PathVariable Long current,
            @ApiParam(name = "limit", value = "每页显示几条", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "teacherQuery", value = "查询条件对象", required = false)
            @RequestBody(required = false)
            TeacherQuery teacherQuery) {
        //创建page对象
        Page<Teacher> pageTeacher = new Page<>(current, limit);
        //构建条件
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            wrapper.like("name", name);
        }
        if (!StringUtils.isEmpty(level)) {
            wrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_create", end);
        }
        //调用方法实现分页
        teacherService.page(pageTeacher, wrapper);
        long total = pageTeacher.getTotal();
        List<Teacher> records = pageTeacher.getRecords();
        return R.ok().data("total", total).data("rows", records);
    }

}

