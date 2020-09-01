package com.julong.enterpriseeureka.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lyt
 * @since 2020-06-24
 */
@Service
@FeignClient("servicehi")
@RequestMapping
public interface IAsCriticalRemindService {

    @RequestMapping(value = "/pro-as-critical-remind/getreminds", method = RequestMethod.POST)
    JSONObject getList(@RequestParam("date")String date);
}
