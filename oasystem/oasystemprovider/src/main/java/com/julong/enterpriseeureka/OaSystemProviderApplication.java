package com.julong.enterpriseeureka;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
//import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableEurekaClient
@RestController
//@MapperScan("com.julong.xiugaijieshao.hospital.mapper")
//@SpringBootApplication(exclude = MybatisAutoConfiguration.class)

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan({"com.julong.enterpriseeureka.spyy.mapper","com.julong.enterpriseeureka.hospital.mapper"})
@ServletComponentScan("com.julong.filter")
//@EnableDistributedTransaction
public class OaSystemProviderApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(OaSystemProviderApplication.class, args);
    }

   /* @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(XiugaijieshaoApplication.class);
    }*/



}
