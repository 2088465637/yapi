//package com.yuanchanglin.yapi.task;
//
//import cn.hutool.http.HttpResponse;
//import cn.hutool.http.HttpUtil;
//import cn.hutool.json.JSONArray;
//import cn.hutool.json.JSONObject;
//import cn.hutool.json.JSONUtil;
//import com.yuanchanglin.yapi.common.CommonService;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
////@Component
//@EnableScheduling
//public class Task {
//    @Scheduled(cron ="0 0 0 ? * 7")  // 0 0 0 ? * 7 *
//    public void sayWord() {
//        Integer classId = 938;
//        String url = "https://opcenter.lanqiao.cn/api/v1/classes/"+classId+"/students/?saas_id=17";
//        HttpResponse execute = HttpUtil.createGet(url).cookie("_ga=GA1.2.955467492.1671583055; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%222635150%22%2C%22first_id%22%3A%22185321d3bf6b33-0389ba302e12aea-26021151-1268496-185321d3bf71147%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg1MzIxZDNiZjZiMzMtMDM4OWJhMzAyZTEyYWVhLTI2MDIxMTUxLTEyNjg0OTYtMTg1MzIxZDNiZjcxMTQ3IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiMjYzNTE1MCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%222635150%22%7D%2C%22%24device_id%22%3A%22185321d3bf6b33-0389ba302e12aea-26021151-1268496-185321d3bf71147%22%7D; Hm_lvt_56f68d0377761a87e16266ec3560ae56=1679651783; _gid=GA1.2.1350229695.1679651786; _gat=1; lqtoken=99eae2251a6a49b9d1ced3286d6eb4d7; Hm_lpvt_56f68d0377761a87e16266ec3560ae56=1679651805; _SESSIONKEY=3c936236-4ba7-4eab-91d0-cb99b6283b72; _LQUSERTYPE=0; platform=OPCENTER-FE")
//                .execute();
//        JSONObject entries = JSONUtil.parseObj(execute.body());
//        JSONArray data = entries.get("data", JSONArray.class);
//        List<LanQiaoStudentVo> lists = data.toList(LanQiaoStudentVo.class);
//        List<LqlevelPo> pos = new ArrayList<>();
//        long l = System.currentTimeMillis();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String format = sdf.format(l);
//        try {
//            l = sdf.parse(format).getTime();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        long finalL = l;
//        lists.forEach(item ->{
//            LqlevelPo lqlevelPo = new LqlevelPo();
//            lqlevelPo.setCreateTime(finalL);
//            lqlevelPo.setLevel(item.getLevel());
//            lqlevelPo.setUserId(item.getStu_id());
//            lqlevelPo.setClassId(classId);
//            pos.add(lqlevelPo);
//        });
//        CommonService.instance().getLqlevelService().saveBatch(pos);
//        System.out.println("运行了");
//    }
//
//}
