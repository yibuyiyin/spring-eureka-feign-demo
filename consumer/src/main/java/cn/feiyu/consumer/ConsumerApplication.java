package cn.feiyu.consumer;

import cn.feiyu.client.IHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {
    @FeignClient("api")
    interface HelloServiceClient extends IHello {
    }
    @RestController
    class TestController {
        @Autowired
        private HelloServiceClient helloServiceClient;
        @GetMapping("/test")
        public String test(String name) {
            return helloServiceClient.hello(name);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
