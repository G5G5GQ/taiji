package com.mall.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.mall.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author gy
 * @date 2024-06-04
 */
@Api(tags = "认证相关接口")
@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @ApiOperation("登录接口")
    @PostMapping(value = "/login")
    public String login(@Valid @RequestBody String name,String password) {
        if(name.equals("username") && password.equals("123456")){
            StpUtil.login(6);
            
        }
        return "ok";
    }
}

