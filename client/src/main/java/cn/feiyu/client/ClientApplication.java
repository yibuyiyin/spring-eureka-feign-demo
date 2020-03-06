package cn.feiyu.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;
import cn.feiyu.api.IHello;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientApplication {

    @RestController
    class HelloController implements IHello {
        @Override
        public String hello(String name) {
            return "hello: " + name;
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

}
