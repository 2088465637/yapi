package com.yuanchanglin.yapi.component;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/imserver/{token}")
@Component
public class WebSocketServer {
    public static final Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    {
        System.out.println("OK");
    }
    @OnOpen
    public void onOpen(Session session, @PathParam("token")String token){
        sessionMap.put(token,session);
        System.out.println("session = " + session + ", token = " + token);
        JSONObject res = new JSONObject();
        JSONArray arr = new JSONArray();
        res.set("users",arr);
        for(Object key: sessionMap.keySet()){
            JSONObject obj = new JSONObject();
            obj.set("token",key);
            arr.add(obj);
        }
        sendAllMessage(JSONUtil.toJsonStr(res));
    }

    @OnClose
    public void onClose(Session session,@PathParam("token")String token){
        sessionMap.remove(token);
    }
    @OnMessage
    public void onMessage(String message,Session session,@PathParam("token")String token){
        System.out.println("message = " + message + ", session = " + session + ", token = " + token);
    }

    private void sendMessage(String message,Session toSession){
        try {
            toSession.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendAllMessage(String message){
        try {
            for(Session session:sessionMap.values()) {
                session.getBasicRemote().sendText(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
