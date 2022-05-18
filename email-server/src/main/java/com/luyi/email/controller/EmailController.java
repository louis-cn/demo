package com.luyi.email.controller;

import com.luyi.email.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: luyi
 * @Description: 邮件服务API
 * @Date: Created in 2022-05-18
 */
@RestController
@RequestMapping("/email")
public class EmailController {

    private Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    EmailService emailService;

    @RequestMapping("/sendEmailByAsync/{recevier}")
    public String sendEmailByAsync(@PathVariable("recevier") String recevier) {
        logger.info("收到异步发送邮件请求 recevier:{}", recevier);
        emailService.sendEmailByAsync(recevier);
        return "SUCCESS";
    }
}
