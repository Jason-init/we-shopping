package com.qizhang.service_business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.qizhang.service_business.dao"})
public class ServiceBusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceBusinessApplication.class, args);
    }
}
