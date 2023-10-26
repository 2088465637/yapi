package com.yuanchanglin.yapi.order.service.impl;

import com.yuanchanglin.yapi.order.entity.OrderPo;
import com.yuanchanglin.yapi.order.mapper.OrderMapper;
import com.yuanchanglin.yapi.order.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuanchanglin
 * @since 2023-10-26
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderPo> implements OrderService {

}
