package com.yuanchanglin.yapi.order.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import com.yuanchanglin.yapi.order.service.OrderDetailService;
import com.yuanchanglin.yapi.order.entity.OrderDetailPo;
import org.springframework.web.bind.annotation.RestController;
import com.yuanchanglin.yapi.base.BaseController;
import io.swagger.annotations.Api;
/**
*  前端控制器
* @author yuanchanglin
* @since 2023-10-26
*/
@Api(value="OrderDetailController",tags={"操作接口"})
@RestController
@RequestMapping("/order/orderDetailPo")
public class OrderDetailController extends BaseController<OrderDetailService,OrderDetailPo> {

}
