package com.dsxdmfz.amqp;

import com.dsxdmfz.amqp.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    RabbitAdmin rabbitAdmin;

    @Test
    public void createExchange(){
//        rabbitAdmin.declareExchange(new DirectExchange("admin.exchange"));

//        rabbitAdmin.declareQueue(new Queue("admin.queue",true));

        rabbitAdmin.declareBinding(new Binding("admin.queue", Binding.DestinationType.QUEUE,"admin.exchange",
                "admin",null));

    }

    /**
     * 1、单播（点对点）
     */
    @Test
    public void contextLoads() {
        //message 需要自己构造一个；定义消息体内容和消息头
//        rabbitTemplate.send(exchang,routingKey,message);

        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq
//        rabbitTemplate.convertAndSend(exchang,routingKey,object);

//        Map<String, Object> map = new HashMap<>();
//        map.put("msg", "这是第一个点对点消息");
//        map.put("data", Arrays.asList("qwe", 123, true));
//        rabbitTemplate.convertAndSend("exchange.direct","qwe.news",map);
        rabbitTemplate.convertAndSend("exchange.direct","qwe.news",new Book("雪中悍刀行","烽火戏诸侯"));
    }

    /**
     * 接收消息，如何将数据自动转化为json发送出去
     */
    @Test
    public void receive(){
        Object object = rabbitTemplate.receiveAndConvert("qwe.news");
        System.out.println(object.getClass());
        System.out.println(object);
    }

    /**
     * 广播
     */
    @Test
    public void sendFanout() {
        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("傲世九重天","风凌天下"));
    }
}
