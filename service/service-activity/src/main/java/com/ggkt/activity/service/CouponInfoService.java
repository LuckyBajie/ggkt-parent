package com.ggkt.activity.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ggkt.entity.model.activity.CouponInfo;
import com.ggkt.entity.model.activity.CouponUse;
import com.ggkt.entity.vo.activity.CouponUseQueryVo;

/**
 * <p>
 * 优惠券信息 服务类
 * </p>
 *
 * @author lff
 * @since 2023-06-05
 */
public interface CouponInfoService extends IService<CouponInfo> {
    //获取已使用优惠券列表
    IPage<CouponUse> selectCouponUsePage(Page<CouponUse> pageParam, CouponUseQueryVo couponUseQueryVo);
}
