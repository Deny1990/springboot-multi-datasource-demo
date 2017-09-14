package com.yuan.bundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
import java.util.*;

/**
 * Created by yuanxin on 17/9/14.
 */
public class ResourceBundleTest
{
    static Logger log = LoggerFactory.getLogger(ResourceBundleTest.class);

    public static void main(String[] args)
        throws InterruptedException
    {
        test();
    }

    private static void test()
        throws InterruptedException
    {
        String[] configs = {"spring-bundle.xml"};

        ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);

        MessageSource ms = (MessageSource)ctx.getBean("myResource");

        Object[] params = {"John", new GregorianCalendar().getTime()};
        log.debug("hello world");
        final Map<String,String> map = new HashMap<String, String>();
        for (int i = 0; i < 2; i++)
        {
            map.put("greeting.common","How are you!{0},today is {1} bbbb");
            String str1 = ms.getMessage("greeting.common", params, Locale.US);
            log.info("greeting.common 值为{}",str1);
            new Thread(new Runnable()
            {
                public void run()
                {
                    updateFile("fmt_resource_en_US.properties",map);
                }
            }).start();
            Thread.currentThread().sleep(2000);

        }
    }

    private static void updateFile(String fileName,Map<String, String> keyValueMap)
    {
        String filePath = ResourceBundleTest.class.getClassLoader().getResource(fileName).getFile();
        Properties props = null;
        BufferedWriter bw = null;

        try {
            filePath = URLDecoder.decode(filePath,"utf-8");
            log.debug("updateProperties propertiesPath:" + filePath);
            props = PropertiesLoaderUtils.loadProperties(new ClassPathResource(fileName));
            log.debug("updateProperties old:"+props);

            // 写入属性文件
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));

            props.clear();// 清空旧的文件

            for (String key : keyValueMap.keySet())
                props.setProperty(key, keyValueMap.get(key));

            log.debug("updateProperties new:"+props);
            props.store(bw, "");
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
