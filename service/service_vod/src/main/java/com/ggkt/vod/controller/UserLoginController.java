package com.ggkt.vod.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ggkt.entity.model.vod.Teacher;
import com.ggkt.entity.vo.vod.TeacherQueryVo;
import com.ggkt.exception.GgktException;
import com.ggkt.result.Result;
import com.ggkt.vod.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author lff
 * @since 2023-05-31
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("admin/vod/user")
// @CrossOrigin
public class UserLoginController {

    @Resource
    private TeacherService teacherService;

    @ApiOperation("用户登录接口")
    @PostMapping("login")
    public Result login(){
        Map<String,String> map = new HashMap<>();
        map.put("token","admin-token");
        return Result.ok(map);
    }

    @ApiOperation("获取用户信息")
    @GetMapping("info")
    public Result info(){
        Map<String,Object> map = new HashMap<>();
        map.put("roles", Arrays.asList("admin"));
        map.put("introduction", "I am a super administrator");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name", "Super Admin");
        return Result.ok(map);
    }

}

