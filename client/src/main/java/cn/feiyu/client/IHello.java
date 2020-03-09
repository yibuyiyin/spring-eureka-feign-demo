package cn.feiyu.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "api", path = "/")
@RequestMapping(path = {"/"})
public interface IHello {
    @GetMapping("/hello")
    String hello(@RequestParam(value = "name") String name);
}
