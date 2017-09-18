package com.yuan.advice.composable;

import com.yuan.advice.controlflow.WaiterDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by yuanxin on 17/9/18.
 */
@Component
public class GreetingComposablePointcut
{
    Logger logger = LoggerFactory.getLogger(GreetingComposablePointcut.class);

    @Bean("pointCut")
    public Pointcut getIntersectionPointcut()
    {
        ComposablePointcut cp = new ComposablePointcut();

        Pointcut pt1 = new ControlFlowPointcut(WaiterDelegate.class,"service");

        NameMatchMethodPointcut pt2 = new NameMatchMethodPointcut();
        pt2.addMethodName("greetTo");
        return cp.intersection(pt1).intersection((Pointcut)pt2);
    }
}
