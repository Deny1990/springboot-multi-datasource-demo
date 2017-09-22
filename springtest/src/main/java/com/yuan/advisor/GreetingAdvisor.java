package com.yuan.advisor;

import com.yuan.service.Waiter;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * Created by yuan on 17/8/11.
 * 切面类
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {


    //切点方法匹配规则
    public boolean matches(Method method, Class<?> targetClass) {
        return "greetTo".equals(method.getName());
    }

    //切点类匹配规则: 为Waiter类或子类
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> clazz) {
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }

}
