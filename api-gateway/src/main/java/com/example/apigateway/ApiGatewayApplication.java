package com.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy      //开启网关：拦截所有请求，任何请求先交给网关，然后再用网关进行转发nginx反向代理；解决跨域问题；
@EnableDiscoveryClient
@SpringCloudApplication     //包括了@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
}
