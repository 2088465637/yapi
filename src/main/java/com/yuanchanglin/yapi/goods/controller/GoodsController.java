package com.yuanchanglin.yapi.goods.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import com.yuanchanglin.yapi.goods.service.GoodsService;
import com.yuanchanglin.yapi.goods.entity.GoodsPo;
import org.springframework.web.bind.annotation.RestController;
import com.yuanchanglin.yapi.base.BaseController;
import io.swagger.annotations.Api;
/**
*  前端控制器
* @author yuanchanglin
* @since 2023-10-26
*/
@Api(value="GoodsController",tags={"商品操作接口"})
@RestController
@RequestMapping("/goods/goodsPo")
public class GoodsController extends BaseController<GoodsService,GoodsPo> {

}
