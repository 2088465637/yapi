package com.yuanchanglin.yapi.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CommonService {
    // 在这里注入业务对象，创建get方法，后续在其他Service层调用的话就不用重复注入了
//    @Autowired
//    private UserService userService;

    @Autowired
    private static CommonService commonService;

    private CommonService() {
    }

    @PostConstruct
    public void init(){
        commonService = this;
    }

    public static CommonService instance(){
        return commonService;
    }

//    public PostUserLikeService getPostUserLikeService() {
//        return postUserLikeService;
//    }

}