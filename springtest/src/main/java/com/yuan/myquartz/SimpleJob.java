package com.yuan.myquartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by yuanxin on 17/8/29.
 */
public class SimpleJob implements Job
{
    public void execute(JobExecutionContext jobExecutionContext)
        throws JobExecutionException
    {
        System.out.println(jobExecutionContext.getTrigger().getKey().getName() + "triggered.time is :" + (new Date()));
    }
}
