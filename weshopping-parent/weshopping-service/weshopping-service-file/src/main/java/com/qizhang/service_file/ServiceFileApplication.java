package com.qizhang.service_file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceFileApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceFileApplication.class, args);
    }
}
