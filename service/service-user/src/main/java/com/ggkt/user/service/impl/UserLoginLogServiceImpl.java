package com.ggkt.user.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ggkt.entity.model.user.UserLoginLog;
import com.ggkt.user.mapper.UserLoginLogMapper;
import com.ggkt.user.service.UserLoginLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登陆记录表 服务实现类
 * </p>
 *
 * @author lff
 * @since 2023-06-05
 */
@Service
public class UserLoginLogServiceImpl extends ServiceImpl<UserLoginLogMapper, UserLoginLog> implements UserLoginLogService {

}
