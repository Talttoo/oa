package com.julong;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;

/**
 * @date 2020/6/23 0023 14:21
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class EnterPriseZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnterPriseZuulApplication.class, args);
//        SpringApplication app = new SpringApplication(EnterPriseZuulApplication.class);
//        app.setBannerMode(Banner.Mode.OFF);
//        app.run(args);
//        System.out.println("zuul网关启动完毕。。。。。。。。");

    }



}
