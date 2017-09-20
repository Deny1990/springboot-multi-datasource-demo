package com.yuan.advice.args;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by yuanxin on 17/9/20.
 */
@Component
@Aspect
@Order(-1)
public class ArgsAspect
{
    Logger logger = LoggerFactory.getLogger(ArgsAspect.class);

    @Before("@args(com.yuan.advice.args.PrintArgs)")
    public void printArgs(JoinPoint joinPoint)
    {
        logger.info("{},此方法入参数标注了PrintArgs注解",joinPoint.getSignature());
    }
}
