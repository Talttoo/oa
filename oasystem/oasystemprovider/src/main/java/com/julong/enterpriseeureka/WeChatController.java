package com.julong.enterpriseeureka;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;



import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@CrossOrigin
@RestController
@RequestMapping("/wechat")
@Slf4j
@EnableSwagger2
public class WeChatController{

    @GetMapping("getAccessToken")
    public String getAccessToken(@RequestParam("appid")String appid, @RequestParam("appSecret")String appSecret){
        System.out.println("收到请求++++++++");
        return WeChatUtil.getAccessToken(appid,appSecret);
    }

    @GetMapping("getJSApiTicket")
    public String getJSApiTicket(@RequestParam("accessToken")String accessToken){
        return WeChatUtil.getJSApiTicket(accessToken);
    }

    @GetMapping("alldept")
    public JSONObject getAllDep(@RequestParam("accessToken")String accessToken){
        return WeChatUtil.getAllDep(accessToken);
    }

    @GetMapping("alluser")
    public JSONObject getAllUser(@RequestParam("accessToken")String accessToken){
        return WeChatUtil.getAllUser(accessToken);
    }

    @GetMapping("getuserbycode")
    public JSONObject getAllUser(@RequestParam("accessToken")String accessToken,@RequestParam("code")String code){
        return WeChatUtil.getUserByCode(accessToken,code);
    }

    @PostMapping("sendremindmessages")
    public JSONObject sendRemindMessage(@RequestParam("jsonParam")JSONObject jsonParam,@RequestParam("requestJson")JSONObject requestJson){
        System.out.println("收到请求++++++++");
        return WeChatUtil.sendRemindMessage(jsonParam,requestJson);
    }

    @PostMapping("sendmessages")
    public JSONObject sendMessage(@RequestParam("jsonParam")JSONObject jsonParam,@RequestParam("requestJson")JSONObject requestJson){
        System.out.println("收到请求++++++++");
        return WeChatUtil.sendRemindMessage(jsonParam,requestJson);
    }
}

