package com.weichuang.fellows44_springboot.service.impl;

import com.weichuang.fellows44_springboot.pojo.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl {


    @RabbitListener(queues = "qingmeng.news")
    public void receiveMsg(Book book){
        System.out.println("收到一条消息 book :" + book);
    }
}
