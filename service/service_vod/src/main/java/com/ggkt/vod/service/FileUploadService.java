package com.ggkt.vod.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 文件上传 服务类
 * </p>
 *
 * @author lff
 * @since 2023-05-31
 */
public interface FileUploadService {
    //文件上传
    String upload(MultipartFile file);
}
