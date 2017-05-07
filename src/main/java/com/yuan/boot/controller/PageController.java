package com.yuan.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

/**
 * Created by yuanxin on 17/5/5.
 */
@Controller
public class PageController
{
   static Logger logger = LoggerFactory.getLogger(PageController.class);

    @RequestMapping("/async/test")
    @ResponseBody
    public Callable<String> callable()
    {
        // 这么做的好处避免web server的连接池被长期占用而引起性能问题，
        // 调用后生成一个非web的服务线程来增加web服务器的吞吐量。
        logger.info("thread is {}", Thread.currentThread().getName());
        Callable<String> callableMthod = new Callable<String>()
        {
            @Override
            public String call()
                throws Exception
            {
                Thread.sleep(3 * 1000L);
                logger.info("hello world");
                logger.info("call thread is {}", Thread.currentThread().getName());
                return "小单 - " + System.currentTimeMillis();
            }
        };
        logger.info("before return callabelMethod");
        return callableMthod;
    }

}
