package com.yuanchanglin.yapi.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanchanglin.yapi.common.CommonController;
import com.yuanchanglin.yapi.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 仿照mybatisPlus的公共Controller
 * @author ycl
 * @since 2018-07-17
 */
public abstract class BaseController<M extends IService<T>,T> extends CommonController {

    @Autowired
    @SuppressWarnings("all")
    protected M baseService;

    @ApiOperation(value = "根据ID查找",httpMethod = "GET")
    @GetMapping(value = "/{id}")
    protected ResultVo getById(@PathVariable Serializable id){
        return ResultVo.successResult(baseService.getById(id));
    }

    @ApiOperation(value = "根据ID列表获取多个实体",httpMethod = "GET")
    @GetMapping(value = "/listByIds")
    protected ResultVo listByIds(String[] ids){
        return ResultVo.successResult(baseService.listByIds(Arrays.asList(ids)));
    }


    @SuppressWarnings("unchecked")
    @ApiOperation(value = "根据条件查询实体对象",httpMethod = "POST")
    @PostMapping(value = "/list")
    protected ResultVo list(@RequestBody BaseQuery baseQuery){
        if(baseQuery.isNeedPaging()){
            // 需要分页，调用分页的方法
            IPage page = baseService.page(baseQuery.page(), baseQuery.queryWrapper());
            return  ResultVo.successResult(page);
        }
        // 不需要分页
        List<T> list = baseService.list(baseQuery.queryWrapper());
        return  ResultVo.successResult(list);
    }

//    @ApiOperation(value = "新增一个实体对象",httpMethod = "POST")
//    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
//    protected ResultVo save(@RequestBody T entity){
//        baseService.save(entity);
//        return ResultVo.successResult();
//    }
//
//    @ApiOperation(value = "新增多个实体对象",httpMethod = "POST")
//    @PostMapping(value = "/addBatch", produces = MediaType.APPLICATION_JSON_VALUE)
//    protected ResultVo saveBatch(@RequestBody Collection<T> entityList){
//        if (entityList.size() <= 0) {
//            return ResultVo.failResult("list is empty");
//        }
//        baseService.saveBatch(entityList,entityList.size());
//        return ResultVo.successResult();
//    }
//
//    @ApiOperation(value = "新增或修改实体对象",httpMethod = "POST")
//    @PostMapping(value = "/addOrUpd", produces = MediaType.APPLICATION_JSON_VALUE)
//    protected ResultVo addOrUpdate(@RequestBody T entity){
//        baseService.saveOrUpdate(entity);
//        return ResultVo.successResult();
//    }
//
//    @ApiOperation(value = "新增或修改多个实体对象",httpMethod = "POST")
//    @PostMapping(value = "/addOrUpdBatch", produces = MediaType.APPLICATION_JSON_VALUE)
//    protected ResultVo addOrUpdateBatch(@RequestBody Collection<T> entityList){
//        if (entityList.size() <= 0) {
//            return ResultVo.failResult("list is empty");
//        }
//        baseService.saveOrUpdateBatch(entityList,entityList.size());
//        return ResultVo.successResult();
//    }
//
//    @ApiOperation(value = "根据ID修改实体对象,传入ID和需要修改的属性",httpMethod = "PUT")
//    @PostMapping(value = "/update")
//    protected ResultVo updateById(@RequestBody T entity){
//        baseService.updateById(entity);
//        return ResultVo.successResult();
//    }
//
//    @ApiOperation(value = "根据ID修改多个实体对象,传入ID和需要修改的属性",httpMethod = "PUT")
//    @PostMapping(value = "/updateBatchById")
//    protected ResultVo updateBatchById(@RequestBody Collection<T> entityList){
//        baseService.updateBatchById(entityList,entityList.size());
//        return ResultVo.successResult();
//    }
//
//    @ApiOperation(value = "根据ID删除实体对象",httpMethod = "DELETE")
//    @DeleteMapping(value = "/{id}")
//    protected ResultVo removeById(@PathVariable Serializable id){
//        baseService.removeById(id);
//        return ResultVo.successResult();
//    }
//
//    @ApiOperation(value = "根据ID批量删除实体对象",httpMethod = "DELETE")
//    @DeleteMapping(value = "/delByIds")
//    protected ResultVo removeByIds(@RequestBody Collection<? extends Serializable> idList){
//        baseService.removeByIds(idList);
//        return ResultVo.successResult();
//    }


}