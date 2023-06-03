package com.ggkt.vod.controller;


import com.ggkt.result.Result;
import com.ggkt.vod.service.FileUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * <p>
 * 文件上传控制器
 * </p>
 *
 * @author lff
 * @since 2023-05-31
 */
@Api(tags = "文件上传接口")
@RestController
@RequestMapping("admin/vod/file")
@CrossOrigin
public class FileUploadController {

    @Resource
    private FileUploadService fileUploadService;

    /**
     * 文件上传
     */
    @ApiOperation(value = "文件上传")
    @PostMapping("upload")
    public Result upload(
            @ApiParam(name = "file", value = "文件", required = true)
            @RequestParam("file") MultipartFile file) {
        String uploadUrl = fileUploadService.upload(file);
        return Result.ok(uploadUrl).message("文件上传成功");
    }


}

