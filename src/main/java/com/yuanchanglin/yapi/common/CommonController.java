package com.yuanchanglin.yapi.common;

import cn.hutool.core.lang.Assert;
import com.yuanchanglin.yapi.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class CommonController {
    // 可以在这里封装controller层通用的方法，后续子类就可以调用这些方法了
    @Autowired
    public HttpServletRequest request;

    public Integer getCurUserId() {
        String token = request.getHeader("token");
        Assert.notEmpty(token, "登录失效，请重新登录");
        String userId = JwtUtil.getVal("userId", token);
        return Integer.valueOf(userId);
    }


}