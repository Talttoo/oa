package com.julong.enterpriseeureka.spyy.controller;


import com.alibaba.fastjson.JSONObject;
import com.julong.enterpriseeureka.spyy.service.IAsCriticalRemindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lyt
 * @since 2020-06-24
 */
@RestController
@RequestMapping("/pro-as-critical-remind")
public class AsCriticalRemindController {

    @Autowired
    IAsCriticalRemindService asCriticalRemindService;

    //    @PostMapping("/")
    @PostMapping("/getreminds")
    public JSONObject getReminds(@RequestParam("date") String date) {
        System.out.println("收到请求.....");

        //log.info(date);
        JSONObject result = asCriticalRemindService.getList(date);

        System.out.println("result:"+result.toJSONString());



        return result;
    }

}
