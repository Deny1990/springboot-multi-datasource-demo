package com.yuan.myquartz;

import org.quartz.*;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import java.util.Date;

/**
 * Created by yuanxin on 17/8/29.
 */
public class SimpleTriggerRuner
{
    public static void main(String[] args)
    {
        JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class).withIdentity("job1_1", "jgroup1").build();
        SimpleTriggerImpl trigger = new SimpleTriggerImpl("hello");
        ScheduleBuilder scheduleBuilder =  SimpleScheduleBuilder.repeatSecondlyForTotalCount(3,1);
        Trigger trigger1 = TriggerBuilder.newTrigger()
            .withIdentity("trigger1_1", "tgroup1")
            .startAt(new Date())
            .withSchedule(scheduleBuilder)
            .build();
//        SchedulerFactory

    }
}
