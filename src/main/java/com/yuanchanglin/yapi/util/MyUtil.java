package com.yuanchanglin.yapi.util;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.BeanUtils;

import java.util.*;

public class MyUtil {

    public static String getIpAddr(String ip){
        String url = "https://qryip.market.alicloudapi.com/lundear/qryip";
        String appcode = "1a38d2c6952d40a285f64750ef6a763b";
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        Map<String, Object> querys = new HashMap<String, Object>();
        querys.put("ip", ip);
        HttpResponse execute = HttpUtil.createGet(url)
                .header("Authorization", "APPCODE " + appcode)
                .form(querys)
                .execute();
        JSONObject entries = JSONUtil.parseObj(execute.body());
        System.out.println(entries);
        if(entries.getInt("status")==0){
            JSONObject addr = JSONUtil.parseObj(JSONUtil.parseObj(entries.getStr("result")).getStr("ad_info"));
            if("中国".equals(addr.getStr("nation"))){
                return addr.getStr("province")+addr.getStr("city");
            }else {
                return addr.getStr("nation");
            }
        }
        return "";
    }

    public static  <T> T copyProperties(Object source,Class<T> target){
        T t = null;
        try {
            t = target.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(source,t);
        return t ;
    }

    public static <T> List<T> copyListProperties(Collection source, Class<T> target){
        List<T> t = new ArrayList();
        Assert.notEmpty(source,"列表不能为空");
        for (Object o : source) {
            t.add(copyProperties(o, target));
        }
        return t;
    }

    public static Integer[] List2IntegerArray(Collection source) {
        Integer[] objects = ArrayUtil.newArray(Integer.class, source.size());
        int i = 0;
        for (Object o : source) {
            objects[i++] = Integer.valueOf(String.valueOf(o));
        }
        return objects;
    }
}
