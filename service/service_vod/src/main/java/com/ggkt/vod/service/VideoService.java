package com.ggkt.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ggkt.entity.model.vod.Video;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author lff
 * @since 2023-06-02
 */
public interface VideoService extends IService<Video> {

    void removeVideoByCourseId(Long id);

    //根据小节id删除小节删除视频
    void removeVideoById(Long id);
}
