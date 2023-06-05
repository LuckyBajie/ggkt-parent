package com.ggkt.vod.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ggkt.entity.model.vod.VideoVisitor;
import com.ggkt.entity.vo.vod.VideoVisitorCountVo;
import com.ggkt.vod.mapper.VideoVisitorMapper;
import com.ggkt.vod.service.VideoVisitorService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 视频来访者记录表 服务实现类
 * </p>
 *
 * @author lff
 * @since 2023-06-03
 */
@Service
public class VideoVisitorServiceImpl extends ServiceImpl<VideoVisitorMapper, VideoVisitor> implements VideoVisitorService {

    //课程统计的接口
    @Override
    public Map<String, Object> findCount(Long courseId, String startDate, String endDate) {
        //调用mapper的方法
        List<VideoVisitorCountVo> videoVisitorVoList =
                baseMapper.findCount(courseId,startDate,endDate);
        //创建map集合
        Map<String, Object> map = new HashMap<>();
        //创建两个list集合，一个代表所有日期，一个代表日期对应数量
        //封装数据  代表所有日期
        List<String> dateList =
                videoVisitorVoList.stream().map(vo->new SimpleDateFormat("yyyy-MM-dd").format(vo.getJoinTime()))
                                .collect(Collectors.toList());
        //代表日期对应数量
        List<Integer> countList = videoVisitorVoList.stream().map(VideoVisitorCountVo::getUserCount)
                .collect(Collectors.toList());
        //放到map集合
        map.put("xData", dateList);
        map.put("yData", countList);
        return map;
    }
}
