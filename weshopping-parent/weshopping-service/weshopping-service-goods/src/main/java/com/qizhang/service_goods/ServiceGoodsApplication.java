package com.qizhang.service_goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.qizhang.service_goods.dao")
public class ServiceGoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceGoodsApplication.class, args);
    }
}
