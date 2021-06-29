package com.qizhang.gateway_system.filter;

import com.qizhang.gateway_system.util.JwtUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取请求对象
        ServerHttpRequest request = exchange.getRequest();
        //获取响应对象
        ServerHttpResponse response = exchange.getResponse();
        //判断当前请求是否是登录请求，如果是登录请求则立即放行
        if (request.getURI().getPath().contains("/admin/login")) {
            return chain.filter(exchange);
        }
        //获取当前请求的请求头信息
        HttpHeaders headers = request.getHeaders();
        //获取请求头中的token
        String token = headers.getFirst("token");
        //判断token是否存在
        if (StringUtils.isEmpty(token)) {
            //因为token不存在, 向用户返回错误信息
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        //进行token的jwt解析
        try {
            JwtUtil.parseJWT(token);
            //jwt解析成功，过滤器放行
            return chain.filter(exchange);

        } catch (Exception e) {
            e.printStackTrace();
            //jwt密钥可能错误，jwt可能过期，等等
            //jwt解析失败，向用户返回错误信息
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
