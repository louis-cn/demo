package com.luyi.user.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="email-server",path = "email")
public interface EmailFeignService {

    @RequestMapping("/sendEmail/{receiver}")
    String sendEmailByAsync(@PathVariable("receiver") String receiver);
}
