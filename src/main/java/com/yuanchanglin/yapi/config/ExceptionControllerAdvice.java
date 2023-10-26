package com.yuanchanglin.yapi.config;


import com.yuanchanglin.yapi.vo.ResultVo;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;

/**
 * controller 增强器
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultVo errorHandler(Exception ex) {
        ex.printStackTrace();
        return ResultVo.errorResult(ex.getMessage());
    }

    /**
     * 拦截捕捉自定义异常 Exception.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = MybatisPlusException.class)
    public ResultVo mybatisPlusErrorHandler(MybatisPlusException ex) {
        ex.printStackTrace();
        return ResultVo.errorResult(ex.getMessage());
    }
    @ResponseBody
    @ExceptionHandler(value = BadSqlGrammarException.class)
    public ResultVo badSqlGrammarErrorHandler(BadSqlGrammarException ex) {
        ex.printStackTrace();
        return ResultVo.errorResult(ex.getCause().getMessage());
    }
    @ResponseBody
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResultVo httpMessageNotReadableErrorHandler(HttpMessageNotReadableException ex) {
        ex.printStackTrace();
        return ResultVo.errorResult(ex.getCause().getMessage());
    }


}


