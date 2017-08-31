package com.yuan.myquartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yuanxin on 17/8/29.
 */
public class SimpleTriggerRuner
{
    static Logger logger = LoggerFactory.getLogger(SimpleJob.class);
    public static void main(String[] args)
        throws ParseException
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = simpleDateFormat.parse("20170831191830");
        JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class).withIdentity("job1_1", "jgroup1").build();
        ScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.repeatSecondlyForTotalCount(10, 1);
        Trigger trigger = TriggerBuilder.newTrigger()
            .withIdentity("trigger1_1", "tgroup1")
            .startNow()
            .withSchedule(scheduleBuilder)
            .build();
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try
        {
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            System.out.println("scheduler start");
            scheduler.start();
            System.out.println("scheduler end");
//            scheduler.shutdown();
            logger.info("scheduler hello");
        }
        catch (SchedulerException e)
        {
            e.printStackTrace();
        }

    }
}
