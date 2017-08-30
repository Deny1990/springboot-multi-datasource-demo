package com.yuan.myquartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Created by yuanxin on 17/8/30.
 */
public class CronTriggerRunner
{
    public static void main(String[] args)
    {
        JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class).withIdentity("job1_2", "jgroup1").build();
        ScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 19 * * * ?");
        Trigger trigger = TriggerBuilder.newTrigger()
            .withIdentity("trigger1_2", "tgroup1")
            .startAt(new Date())
            .withSchedule(scheduleBuilder)
            .build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try
        {
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        }
        catch (SchedulerException e)
        {
            e.printStackTrace();
        }
    }
}
