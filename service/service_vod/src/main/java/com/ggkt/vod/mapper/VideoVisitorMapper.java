package com.ggkt.vod.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ggkt.entity.model.vod.VideoVisitor;
import com.ggkt.entity.vo.vod.VideoVisitorCountVo;

import java.util.List;

/**
 * <p>
 * 视频来访者记录表 Mapper 接口
 * </p>
 *
 * @author lff
 * @since 2023-06-03
 */
public interface VideoVisitorMapper extends BaseMapper<VideoVisitor> {

    List<VideoVisitorCountVo> findCount(Long courseId, String startDate, String endDate);
}
