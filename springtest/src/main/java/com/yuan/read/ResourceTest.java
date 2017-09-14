package com.yuan.read;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created by yuanxin on 17/9/14.
 */
public class ResourceTest
{
    public static void main(String[] args)
        throws IOException, InterruptedException
    {
        Resource resource = new ClassPathResource("fmt_resource_en_US.properties");
        for (int i = 0; i <3 ; i++)
        {
            System.out.println(String.valueOf(resource.lastModified()));
            Thread.currentThread().sleep(10000l);
        }
    }
}
