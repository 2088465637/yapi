package com.yuanchanglin.yapi.shop.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import com.yuanchanglin.yapi.shop.service.DeskService;
import com.yuanchanglin.yapi.shop.entity.DeskPo;
import org.springframework.web.bind.annotation.RestController;
import com.yuanchanglin.yapi.base.BaseController;
import io.swagger.annotations.Api;
/**
*  前端控制器
* @author yuanchanglin
* @since 2023-10-26
*/
@Api(value="DeskController",tags={"操作接口"})
@RestController
@RequestMapping("/shop/deskPo")
public class DeskController extends BaseController<DeskService,DeskPo> {

}
