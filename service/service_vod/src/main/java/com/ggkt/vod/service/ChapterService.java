package com.ggkt.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ggkt.entity.model.vod.Chapter;
import com.ggkt.entity.vo.vod.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author lff
 * @since 2023-06-02
 */
public interface ChapterService extends IService<Chapter> {

    List<ChapterVo> getNestedTreeList(Long courseId);

    void removeChapterByCourseId(Long id);
}
