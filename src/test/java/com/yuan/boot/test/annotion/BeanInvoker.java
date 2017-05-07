package com.yuan.boot.test.annotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by yuanxin on 17/5/4.
 */
@Component
public class BeanInvoker
{
    @Autowired
    private List<BeanInterface> list;

    @Autowired
    private Map<String, BeanInterface> map;

    public void say() {
        if (null != list && 0 != list.size()) {
            for (BeanInterface bean : list) {
                System.out.println(bean.getClass().getName());
            }
        } else {
            System.out.println(" list is null !");
        }

        if (null != map && 0 != map.size()) {
            for (Map.Entry<String, BeanInterface> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "      " + entry.getValue().getClass().getName());
            }
        } else {
            System.out.println("map is null !");
        }
    }
}
