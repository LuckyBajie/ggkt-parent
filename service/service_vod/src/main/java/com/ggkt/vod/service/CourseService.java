package com.ggkt.vod.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ggkt.entity.model.vod.Course;
import com.ggkt.entity.vo.vod.CourseFormVo;
import com.ggkt.entity.vo.vod.CoursePublishVo;
import com.ggkt.entity.vo.vod.CourseQueryVo;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author lff
 * @since 2023-06-02
 */
public interface CourseService extends IService<Course> {

    //课程列表
    Map<String, Object> findPage(Page<Course> pageParam, CourseQueryVo courseQueryVo);

    Long saveCourseInfo(CourseFormVo courseFormVo);

    //根据id获取课程信息
    CourseFormVo getCourseFormVoById(Long id);

    //根据id修改课程信息
    void updateCourseById(CourseFormVo courseFormVo);

    CoursePublishVo getCoursePublishVo(Long id);

    boolean publishCourseById(Long id);

    void removeCourseById(Long id);
}
