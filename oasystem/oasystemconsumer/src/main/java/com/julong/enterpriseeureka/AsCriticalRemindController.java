package com.julong.enterpriseeureka;


import com.alibaba.fastjson.JSONObject;
import com.julong.enterpriseeureka.service.IAsCriticalRemindService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@Slf4j
@RequestMapping("/as-critical-remind")
public class AsCriticalRemindController {

    @Autowired
    IAsCriticalRemindService asCriticalRemindService;

    //    @PostMapping("/")
    @PostMapping("/getreminds")
    public JSONObject getCriticalReminds() {

        return asCriticalRemindService.getList("2020.06.18");
    }

}
