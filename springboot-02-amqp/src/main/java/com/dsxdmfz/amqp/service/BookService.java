package com.dsxdmfz.amqp.service;

import com.dsxdmfz.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Date: 2019/5/20
 * @Auther: lez
 */
@Service
public class BookService {

    @RabbitListener(queues = "qwe.msg")
    public void receive(Book book) {
        System.out.println("收到的消息："+book);
    }

    @RabbitListener(queues = "qwe.news")
    public void receive02(Message message) {
        System.out.println("收到的消息message："+message);
        System.out.println("收到的消息Body："+message.getBody());
        System.out.println("收到的消息Mp："+message.getMessageProperties());
    }

}
