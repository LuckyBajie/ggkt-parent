package com.ggkt.vod.controller;


import com.ggkt.result.Result;
import com.ggkt.vod.service.VideoVisitorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 视频来访者记录表 前端控制器
 * </p>
 *
 * @author lff
 * @since 2023-06-03
 */
@Api(value = "VideoVisitor管理", tags = "VideoVisitor管理")
@RestController
@RequestMapping(value = "/admin/vod/videoVisitor")
// @CrossOrigin
public class VideoVisitorController {

    @Autowired
    private VideoVisitorService videoVisitorService;

    @ApiOperation("显示统计数据")
    @GetMapping("findCount/{courseId}/{startDate}/{endDate}")
    public Result showChart(
            @ApiParam("开始时间") @PathVariable Long courseId,
            @ApiParam("开始时间") @PathVariable String startDate,
            @ApiParam("结束时间") @PathVariable String endDate) {

        Map<String, Object> map = videoVisitorService.findCount(courseId, startDate, endDate);
        return Result.ok(map);
    }
}

