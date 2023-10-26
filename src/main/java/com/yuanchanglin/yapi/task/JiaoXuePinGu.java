package com.yuanchanglin.yapi.task;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//@Component
@EnableScheduling
public class JiaoXuePinGu {

    private Map<String,HashSet<String>> userSet = new HashMap<>();
    private Map<String,String> map = new HashMap<>();

//    @Scheduled(cron ="0/4 * * * * ?")
    public void scores(){
        String url = "https://opcenter.lanqiao.cn/api/v1/svc/sms/teacher_eva/teacher_op/details/?page=1&page_size=15&eva_event_id=99";
        HttpResponse execute = HttpUtil.createGet(url).cookie("_ga=GA1.2.955467492.1671583055; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%222635150%22%2C%22first_id%22%3A%22185321d3bf6b33-0389ba302e12aea-26021151-1268496-185321d3bf71147%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg1MzIxZDNiZjZiMzMtMDM4OWJhMzAyZTEyYWVhLTI2MDIxMTUxLTEyNjg0OTYtMTg1MzIxZDNiZjcxMTQ3IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiMjYzNTE1MCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%222635150%22%7D%2C%22%24device_id%22%3A%22185321d3bf6b33-0389ba302e12aea-26021151-1268496-185321d3bf71147%22%7D; Hm_lvt_56f68d0377761a87e16266ec3560ae56=1679651783; _gid=GA1.2.1350229695.1679651786; _gat=1; lqtoken=99eae2251a6a49b9d1ced3286d6eb4d7; Hm_lpvt_56f68d0377761a87e16266ec3560ae56=1679651805; _SESSIONKEY=3c936236-4ba7-4eab-91d0-cb99b6283b72; _LQUSERTYPE=0; platform=OPCENTER-FE")
                .execute();
        JSONObject entries = JSONUtil.parseObj(execute.body());
        entries = JSONUtil.parseObj(entries.get("data"));
        JSONArray data = entries.get("results", JSONArray.class);
        data.forEach(i->{
            JSONObject obj = JSONUtil.parseObj(i);
            // 平均分
            String avg_score = obj.getStr("avg_score");
            // 班级id
            String class_id = obj.getStr("class_id");
            if(map.size()!=3){
                map.put(class_id,avg_score);
                HashSet<String> users = new HashSet<>();
                userSet.put(class_id,users);
            }else{
                String score = map.get(class_id);
                if(!avg_score.equals(score)){
                    findStuName(Integer.valueOf(class_id),avg_score);
                    map.put(class_id,avg_score);
                }
            }


        });
    }
    public void findStuName(Integer classId,String avg_score){
        String url = "https://opcenter.lanqiao.cn/api/v1/svc/sms/teacher_eva/teacher_op/details/1087/student_submit/?class_id="+classId+"&teacher_id=36289";
        HttpResponse execute = HttpUtil.createGet(url).cookie("_ga=GA1.2.955467492.1671583055; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%222635150%22%2C%22first_id%22%3A%22185321d3bf6b33-0389ba302e12aea-26021151-1268496-185321d3bf71147%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg1MzIxZDNiZjZiMzMtMDM4OWJhMzAyZTEyYWVhLTI2MDIxMTUxLTEyNjg0OTYtMTg1MzIxZDNiZjcxMTQ3IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiMjYzNTE1MCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%222635150%22%7D%2C%22%24device_id%22%3A%22185321d3bf6b33-0389ba302e12aea-26021151-1268496-185321d3bf71147%22%7D; Hm_lvt_56f68d0377761a87e16266ec3560ae56=1679651783; _gid=GA1.2.1350229695.1679651786; _gat=1; lqtoken=99eae2251a6a49b9d1ced3286d6eb4d7; Hm_lpvt_56f68d0377761a87e16266ec3560ae56=1679651805; _SESSIONKEY=3c936236-4ba7-4eab-91d0-cb99b6283b72; _LQUSERTYPE=0; platform=OPCENTER-FE")
                .execute();
        JSONObject entries = JSONUtil.parseObj(execute.body());
        JSONArray data = entries.get("data", JSONArray.class);
        HashSet<String> userList = userSet.get(String.valueOf(classId));
        data.forEach(i->{
            JSONObject obj = JSONUtil.parseObj(i);
            Boolean is_submit = obj.getBool("is_submit");
            if(is_submit){
                // 平均分
//                int student_id = obj.getInt("student_id");
                // 班级id
                String student_name = obj.getStr("student_name");

                boolean contains = userList.contains(student_name);
                if(!contains){
                    System.out.println("学生姓名:"+student_name+"    当前评分:"+avg_score);
                    userList.add(student_name);
                    userSet.put(String.valueOf(classId),userList);
                }
            }
        });
    }
}
