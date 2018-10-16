package com.example.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;//rest风格 调用的都是http协议
    @HystrixCommand(fallbackMethod = "helloFallback")  //断路器
    public String helloservice() {
        return restTemplate
                .getForEntity("http://HELLO-World", String.class) .getBody(); //负载均衡
    }
    public String helloFallback() { return "error";
    }
}
