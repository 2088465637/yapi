package com.yuanchanglin.yapi.controller;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.yuanchanglin.yapi.vo.EmailVo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api("接口测试")
public class ApiController {


    @GetMapping("/test")
    public Map<String,Object> emailTest(String name){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg","OK");
        map.put("data",name+"你真的很优秀!");
        return map;
    }
    @PostMapping("/test")
    public Map<String,Object> test2(@RequestParam  HashMap<String,Object> param){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg","OK");
        map.put("data",param.get("name")+"你真的很厉害");
        return map;
    }

    @GetMapping("/sendEmail")
    public Map<String,Object> sendEmail(EmailVo vo){
        MailAccount account = new MailAccount();
        account.setHost("smtp.qq.com");
        account.setPort(465);
        account.setAuth(true);
        account.setSslEnable(true);
        account.setFrom(vo.getName()+"<1040068055@qq.com>");
//        account.setUser("");
        account.setPass("smygdaxwfqfvbfdg");
        MailUtil.send( account,vo.getTo(),vo.getSubject(), vo.getContent(),false);
        Map r = new HashMap<String,Object>();
        return r;
    }
    @GetMapping("/sendMyEmail")
    public Map<String,Object> sendMyEmail(EmailVo vo){
        MailAccount account = new MailAccount();
        account.setHost("smtp.qq.com");
        account.setPort(465);
        account.setAuth(true);
        account.setSslEnable(true);
        account.setFrom(vo.getName()+"<"+vo.getFrom()+">");
//        account.setUser("");
        account.setPass(vo.getPass());
        MailUtil.send( account,vo.getTo(),vo.getSubject(), vo.getContent(),false);
        Map r = new HashMap<String,Object>();
        r.put("msg","OK");
        return r;
    }
}
