package com.example.feignconsumer.feignconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("hello-World")   //把项目hello-service加入负载均衡 和断路器
public interface HelloService {
    @RequestMapping("/")         //访问hello-service项目里的/
    String hello();
}
