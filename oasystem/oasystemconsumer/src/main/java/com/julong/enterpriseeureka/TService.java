package com.julong.enterpriseeureka;


import com.julong.enterpriseeureka.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@FeignClient("servicehi")
@RequestMapping
public interface TService {


    @GetMapping("/dkyy/area/getsring")
    String getstring();


    @RequestMapping(value = "/dkyy/area/getzongheinfo", method = RequestMethod.POST)
    CommonReturnVo getzongheinfo(@RequestParam("date") String date);


    @RequestMapping(value = "/dkyy/area/getmenzhenshouru", method = RequestMethod.POST)
    List<MenZhenShouRuReturn> getmenzhenshouru(@RequestBody QueryDateVo querydatevo);

    @RequestMapping(value = "/dkyy/area/getzmenzhendata", method = RequestMethod.POST)
    ZongHeQueryVo getzMenZhenData(@RequestParam("date")String date);

    @RequestMapping(value = "/dkyy/area/getzhushouru", method = RequestMethod.POST)
    public List<ZhuYuanShouRuReturn> getzhushouru(@RequestBody QueryDateVo querydatevo);

}

