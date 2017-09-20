package com.yuan.advice.args;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yuanxin on 17/9/20.
 */
public class ArgsAspectTest
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-args.xml");
//        ToneModel toneModel = (ToneModel)context.getBean("toneModel");
//        toneModel.methodA("oneModel");
        ParentModel toneModel = (ParentModel)context.getBean("parentModel");
        toneModel.methodA("oneModel");
    }
}
