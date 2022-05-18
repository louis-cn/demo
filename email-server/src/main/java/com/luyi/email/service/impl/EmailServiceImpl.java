package com.luyi.email.service.impl;

import com.luyi.email.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author: luyi
 * @Description: 邮件发送实现类
 * @Date: Created in 2022-05-18
 */
@Service
public class EmailServiceImpl implements EmailService {

    private Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Value("${spring.mail.content}")
    private String content;

    @Value("${spring.mail.title}")
    private String title;

    @Override
    @Async
    public void sendEmailByAsync(String recevier) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(recevier);
        mailMessage.setSubject(title);
        mailMessage.setText(content);
        try {
            javaMailSender.send(mailMessage);
            logger.info("{} 邮件发送成功！邮件内容：{}",recevier,content);
        } catch (MailException mailException) {
            logger.error("{} 邮件发送失败！错误信息{} ",recevier,mailException.getMessage());
        }
    }
}
