package com.julong.enterpriseeureka.spyy.controller;


import com.julong.enterpriseeureka.spyy.service.IAreaService;
import com.julong.enterpriseeureka.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-07-09
 */
@CrossOrigin
@RestController
@RequestMapping("/dkyy/area")
@Slf4j
@EnableSwagger2
public class AreaController {

    @Autowired
    IAreaService iareaservice;


    //    @PostMapping("/")
    @RequestMapping(value = "/getzmenzhendata", method = RequestMethod.POST)
    public ZongHeQueryVo getzMenZhenData(@RequestParam("date") String date) {

        System.out.println("收到请求");
        log.info(date);
        ZongHeQueryVo zonghequeryvo = iareaservice.getMenZhenDataByRiQi(date);


        return zonghequeryvo;
    }


    @PostMapping("/getmenzhenshouru")
    public List<MenZhenShouRuReturn> getmenzhenshouru(@RequestBody QueryDateVo querydatevo) {

        log.info(querydatevo.toString());

//        QueryDateVo.set      QueryDateVo.getBegintime().replaceAll("-", ".");

        querydatevo.setBegintime(querydatevo.getBegintime().replaceAll("-", "."));
        querydatevo.setEndtime(querydatevo.getEndtime().replaceAll("-", "."));
        List<MenZhenShouRuReturn> menzhenKeShiShouRu = iareaservice.getMenzhenKeShiShouRu(querydatevo);


        return menzhenKeShiShouRu;
    }


    @PostMapping("/getzhushouru")
    public List<ZhuYuanShouRuReturn> getzhushouru(@RequestBody QueryDateVo querydatevo) {

        log.info(querydatevo.toString());


        querydatevo.setBegintime(querydatevo.getBegintime().replaceAll("-", "."));
        querydatevo.setEndtime(querydatevo.getEndtime().replaceAll("-", "."));
        List<ZhuYuanShouRuReturn> zhuYuanShouru = iareaservice.getZhuYuanShouru(querydatevo);


        return zhuYuanShouru;
    }

    /*
       export const GETHOS =params=>req('get','/dkyy/area/getzmenzhendata',params)
       export const MZSR =params=>req('post','/dkyy/area/getmenzhenshouru',params)
       export const ZYSR =params=>req('post','/dkyy/area/getzhushouru',params)*/
    @GetMapping("/getsring")
    public String getstring() {
        System.out.println("提供者");
        return "来自提供者tgz";
    }

}
