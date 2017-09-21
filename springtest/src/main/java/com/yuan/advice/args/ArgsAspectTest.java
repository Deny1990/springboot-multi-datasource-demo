package com.yuan.advice.args;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yuanxin on 17/9/20.
 */
public class ArgsAspectTest
{
    static Logger logger = LoggerFactory.getLogger(ArgsAspect.class);

    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-args.xml");

        ArgsModel argsModel = (ArgsModel)context.getBean("argsModel");
        ParentModel parentModel = (ParentModel)context.getBean("parentModel");
        ToneModel toneModel = (ToneModel)context.getBean("toneModel");
        argsModel.testArgs(parentModel);
        argsModel.testArgs(toneModel);
    }

}
