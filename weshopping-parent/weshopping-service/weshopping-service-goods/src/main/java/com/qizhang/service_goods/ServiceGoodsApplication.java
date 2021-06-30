package com.qizhang.service_goods;

import com.qizhang.common.util.IdWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.qizhang.service_goods.dao")
public class ServiceGoodsApplication {

    @Value("${workerId}")
    private long workerId;

    @Value("${datacenterId}")
    private long datacenterId;

    public static void main(String[] args) {
        SpringApplication.run(ServiceGoodsApplication.class, args);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(workerId, datacenterId);
    }
}
