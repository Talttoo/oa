package com.julong.enterpriseeureka;

import com.julong.enterpriseeureka.vo.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
public class BController {


    @Autowired
    RestTemplate restTemplate;

    @Value("${server.port}")
    String port;

    @GetMapping("/xiaofei")
    @HystrixCommand(fallbackMethod = "orderToUserInfoFallback")
    public String findUserById() {
//        return restTemplate.getForObject("http://servicehi/getsring", String.class);

        System.out.println(port);
        System.out.println(LocalDateTime.now().toString());
        return LocalDateTime.now().toString() + "  " + restTemplate.getForEntity("http://servicehi/getsring", String.class).getBody();
    }


    public String orderToUserInfoFallback() {

        return "服务降级.";
    }


    @Autowired
    DiscoveryClient discoveryclient;

    @GetMapping("/discovery")
    public List<String> findUserById2() {
        List<String> services = discoveryclient.getServices();

        return services;
    }

    @Autowired
    TService tservice;

    @GetMapping("/fegin")
    public String findUserById3() {
//        return restTemplate.getForObject("http://servicehi/getsring", String.class);
        String getstring = tservice.getstring();
        System.out.println("fegin:66 " + getstring);
        System.out.println(tservice);
        return LocalDateTime.now().toString() + "  中777  " + getstring;
    }





    @GetMapping("/getzongheinfo_fegin")
    public CommonReturnVo getzongheinfo() {
        CommonReturnVo getzongheinfo = tservice.getzongheinfo("2017-03-15");
        System.out.println(getzongheinfo);

        return getzongheinfo;
    }


    @PostMapping("/getmenzhenshouru_fegin")
    public List<MenZhenShouRuReturn> getmenzhenshouru(@RequestBody QueryDateVo querydatevo) {

        List<MenZhenShouRuReturn> getmenzhenshouru = tservice.getmenzhenshouru(querydatevo);
        System.out.println(getmenzhenshouru);

        return getmenzhenshouru;
    }


    @GetMapping("/getzmenzhendata")
    public ZongHeQueryVo getzMenZhenData(String date) {

        log.info(date);
        System.out.println("收到请求");
        ZongHeQueryVo zonghequeryvo = tservice.getzMenZhenData(date);


        return zonghequeryvo;
    }

    @PostMapping("/getzhushouru_fegin")
    public List<ZhuYuanShouRuReturn> getzhushouru(@RequestBody QueryDateVo querydatevo) {

        log.info(querydatevo.toString());


        querydatevo.setBegintime(querydatevo.getBegintime().replaceAll("-", "."));
        querydatevo.setEndtime(querydatevo.getEndtime().replaceAll("-", "."));
        List<ZhuYuanShouRuReturn> zhuYuanShouru = tservice.getzhushouru(querydatevo);


        return zhuYuanShouru;

    }


}


 /*
    export const GETHOS =params=>req('get','/dkyy/area/getzmenzhendata',params)
    export const MZSR =params=>req('post','/dkyy/area/getmenzhenshouru',params)
    export const ZYSR =params=>req('post','/dkyy/area/getzhushouru',params)

   */