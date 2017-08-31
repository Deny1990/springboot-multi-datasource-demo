package com.yuan.myquartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by yuanxin on 17/8/29.
 */
public class SimpleJob implements Job
{
    static Logger logger = LoggerFactory.getLogger(SimpleJob.class);
    public void execute(JobExecutionContext jobExecutionContext)
        throws JobExecutionException
    {
        logger.info("start exectue");
        System.out.println("hello world");
        System.out.println(jobExecutionContext.getTrigger().getKey().getName() + "triggered.time is :" + (new Date()));
    }
}
