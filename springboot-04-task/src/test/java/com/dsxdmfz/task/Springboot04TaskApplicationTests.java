package com.dsxdmfz.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot04TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("测试");
        message.setText("邮件发送测试");
        message.setTo("dsxdmfz@163.com");
        message.setFrom("534277194@qq.com");
        javaMailSender.send(message);
    }

    @Test
    public void test() throws MessagingException {
        //创建一个复杂邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);

        //邮件设置
        mimeMessageHelper.setSubject("测试");
        mimeMessageHelper.setText("<b style='color:red'>邮件发送测试</b>",true);//默认不支持html
        mimeMessageHelper.setTo("dsxdmfz@163.com");
        mimeMessageHelper.setFrom("534277194@qq.com");

        //上传文件
        mimeMessageHelper.addAttachment("iamjustageek.jpeg",new File("D:\\图\\iamjustageek.jpeg"));

        javaMailSender.send(mimeMessage);

    }

}
