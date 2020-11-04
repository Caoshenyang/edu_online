package com.yang.education.controller;

import com.yang.commonutils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: csy
 * @Date: 2020/11/3 21:43
 * @Description: 登录
 */

@RestController
@RequestMapping("/edu_service/user")
@CrossOrigin
public class LoginController {


    @ApiOperation(value = "登录")
    @PostMapping("login")
    public R login() {
        return R.ok().data("token","admin");
    }

    @ApiOperation(value = "登录")
    @GetMapping("info")
    public R info() {
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }

}
