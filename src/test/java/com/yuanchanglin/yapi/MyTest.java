package com.yuanchanglin.yapi;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yuanchanglin.yapi.util.MyUtil;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyTest {
// 服务器信息: yuanchanglin.com   pwd:Ycl99999
    /**
     * 发送短信测试接口
     * 数据:{"msg":"�ɹ�","smsid":"16800103762868302488628362","code":"0","balance":"18"}
     */
    @Test
    void sendSMS(){
        String url ="https://gyytz.market.alicloudapi.com/sms/smsSend";
        String appcode = "1a38d2c6952d40a285f64750ef6a763b";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        Map<String, Object> querys = new HashMap<String, Object>();
        querys.put("mobile", "15283079837");
        querys.put("param", "**code**:12345,**minute**:5");
        querys.put("smsSignId", "2e65b1bb3d054466b82f0c9d125465e2");
        querys.put("templateId", "908e94ccf08b4476ba6c876d13f084ad");
        HttpResponse execute = HttpUtil.createPost(url)
                .header("Authorization", "APPCODE " + appcode)
                .form(querys)
                .execute();
        System.out.println(execute.body());
    }
    /**
     * ip地址接口
     * 数据:{"status":0,"message":"Success","request_id":"83d2f1384f144ef1a74dc2a416bd08f0","result":{"ip":"112.36.236.188","location":{"lat":36.68013,"lng":117.06533},"ad_info":{"nation":"中国","province":"山东省","city":"济南市","district":"历城区","adcode":370112}}}
    */
    @Test
    void ipAddrTest(){
        String url = "https://qryip.market.alicloudapi.com/lundear/qryip";
        String appcode = "1a38d2c6952d40a285f64750ef6a763b";
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        Map<String, Object> querys = new HashMap<String, Object>();
        querys.put("ip", "112.36.236.188");
        HttpResponse execute = HttpUtil.createGet(url)
                .header("Authorization", "APPCODE " + appcode)
                .form(querys)
                .execute();
        System.out.println(execute.body());
    }
    @Test
    void ipAddrTest2(){
        String ipAddr = MyUtil.getIpAddr("180.149.130.16");
        System.out.println(ipAddr);
    }

    @Test
    void randTest(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString(true));
    }
    @Test
    void dateFormatTest(){
        long l = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(new Date());
        try {
            System.out.println(sdf.parse(format).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void emailTest(){
        MailAccount account = new MailAccount();
        account.setHost("smtp.qq.com");
        account.setPort(465);
        account.setAuth(true);
        account.setSslEnable(true);
        account.setFrom("1040068055@qq.com");
        account.setPass("smygdaxwfqfvbfdg");
        MailUtil.send( account,"ycl@yuanchanglin.com","修改密码", "点击链接以设置新的密码 https://",false);
    }

    @Test
    void stuLevelTest(){
        String url = "https://opcenter.lanqiao.cn/api/v1/classes/938/students/?saas_id=17";
        HttpResponse execute = HttpUtil.createGet(url).cookie("_ga=GA1.2.955467492.1671583055; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%222635150%22%2C%22first_id%22%3A%22185321d3bf6b33-0389ba302e12aea-26021151-1268496-185321d3bf71147%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg1MzIxZDNiZjZiMzMtMDM4OWJhMzAyZTEyYWVhLTI2MDIxMTUxLTEyNjg0OTYtMTg1MzIxZDNiZjcxMTQ3IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiMjYzNTE1MCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%222635150%22%7D%2C%22%24device_id%22%3A%22185321d3bf6b33-0389ba302e12aea-26021151-1268496-185321d3bf71147%22%7D; Hm_lvt_56f68d0377761a87e16266ec3560ae56=1679651783; _gid=GA1.2.1350229695.1679651786; _gat=1; lqtoken=99eae2251a6a49b9d1ced3286d6eb4d7; Hm_lpvt_56f68d0377761a87e16266ec3560ae56=1679651805; _SESSIONKEY=3c936236-4ba7-4eab-91d0-cb99b6283b72; _LQUSERTYPE=0; platform=OPCENTER-FE")
                .execute();
        JSONObject entries = JSONUtil.parseObj(execute.body());
        JSONArray data = entries.get("data", JSONArray.class);
//        List<LanQiaoStudentVo> lists = data.toList(LanQiaoStudentVo.class);
//        lists.forEach(i ->{
//            System.out.println(i.getStu_id() +"   "+i.getReal_name());
//        });
    }


    @Test
    void pingguTest(){
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
        });
    }

    @Test
    void t111(){
        System.out.println("aaa");
    }

    @Test
    void stuNameTest(){
        HashSet<String> users = new HashSet<>();
        users.add("胡彤源");
        users.add("陈柳雪");
        users.add("罗露");
        users.add("彭明月");
        users.add("刘双梅");

        int classId = 938;
        String url = "https://opcenter.lanqiao.cn/api/v1/svc/sms/teacher_eva/teacher_op/details/1087/student_submit/?class_id="+classId+"&teacher_id=36289";
        HttpResponse execute = HttpUtil.createGet(url).cookie("_ga=GA1.2.955467492.1671583055; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%222635150%22%2C%22first_id%22%3A%22185321d3bf6b33-0389ba302e12aea-26021151-1268496-185321d3bf71147%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg1MzIxZDNiZjZiMzMtMDM4OWJhMzAyZTEyYWVhLTI2MDIxMTUxLTEyNjg0OTYtMTg1MzIxZDNiZjcxMTQ3IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiMjYzNTE1MCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%222635150%22%7D%2C%22%24device_id%22%3A%22185321d3bf6b33-0389ba302e12aea-26021151-1268496-185321d3bf71147%22%7D; Hm_lvt_56f68d0377761a87e16266ec3560ae56=1679651783; _gid=GA1.2.1350229695.1679651786; _gat=1; lqtoken=99eae2251a6a49b9d1ced3286d6eb4d7; Hm_lpvt_56f68d0377761a87e16266ec3560ae56=1679651805; _SESSIONKEY=3c936236-4ba7-4eab-91d0-cb99b6283b72; _LQUSERTYPE=0; platform=OPCENTER-FE")
                .execute();
        JSONObject entries = JSONUtil.parseObj(execute.body());
        JSONArray data = entries.get("data", JSONArray.class);
        data.forEach(i->{
            JSONObject obj = JSONUtil.parseObj(i);
            Boolean is_submit = obj.getBool("is_submit");
            if(is_submit){
                // 平均分
                int student_id = obj.getInt("student_id");
                // 班级id
                String student_name = obj.getStr("student_name");
                boolean contains = users.contains(student_name);
                if(!contains){
                    System.out.println(student_name);
                }
            }
        });
    }
}
