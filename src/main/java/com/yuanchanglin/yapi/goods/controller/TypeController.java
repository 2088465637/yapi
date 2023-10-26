package com.yuanchanglin.yapi.goods.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import com.yuanchanglin.yapi.goods.service.TypeService;
import com.yuanchanglin.yapi.goods.entity.TypePo;
import org.springframework.web.bind.annotation.RestController;
import com.yuanchanglin.yapi.base.BaseController;
import io.swagger.annotations.Api;
/**
*  前端控制器
* @author yuanchanglin
* @since 2023-10-26
*/
@Api(value="TypeController",tags={"商品分类操作接口"})
@RestController
@RequestMapping("/goods/typePo")
public class TypeController extends BaseController<TypeService,TypePo> {

}
