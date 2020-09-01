package com.julong.enterpriseeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EnterpriseeurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnterpriseeurekaApplication.class, args);
    }

}
