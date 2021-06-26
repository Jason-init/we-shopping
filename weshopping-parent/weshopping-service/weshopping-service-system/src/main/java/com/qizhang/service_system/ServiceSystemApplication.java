package com.qizhang.service_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.qizhang.service_system.dao"})
public class ServiceSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSystemApplication.class, args);
    }
}
