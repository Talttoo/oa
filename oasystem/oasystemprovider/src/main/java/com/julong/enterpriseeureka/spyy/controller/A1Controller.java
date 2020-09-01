package com.julong.enterpriseeureka.spyy.controller;


import com.julong.enterpriseeureka.spyy.service.IA1Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-01-06
 */
@RestController
@RequestMapping("/spyy/a1")
@Slf4j
public class A1Controller {


    @Autowired
    IA1Service ia1service;

    @GetMapping("/charu")
    public String charu() {
        log.info("charu..........");


        ia1service.charu();

        return "charu";
    }

}
