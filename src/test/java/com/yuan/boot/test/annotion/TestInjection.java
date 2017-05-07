package com.yuan.boot.test.annotion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by yuanxin on 17/5/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestInjection
{

    @Autowired
    BeanInvoker beanInvoker;


    @Test
    public void testMultiBean() {
        beanInvoker.say();
    }

}
