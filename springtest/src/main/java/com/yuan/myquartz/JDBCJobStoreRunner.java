package com.yuan.myquartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

/**
 * Created by yuanxin on 17/8/31.
 */
public class JDBCJobStoreRunner
{
    static Logger logger = LoggerFactory.getLogger(JDBCJobStoreRunner.class);
    public static void main(String args[]) {
        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            List<String> triggerGroups = scheduler.getTriggerGroupNames();
            for (int i = 0; i < triggerGroups.size(); i++) {
                Set<TriggerKey> triggers = scheduler.getTriggerKeys(GroupMatcher.triggerGroupEquals(triggerGroups.get(i)));
                for (TriggerKey triggerkey : triggers)
                {
                    Trigger tg  =  scheduler.getTrigger(triggerkey);
                    if (tg instanceof SimpleTrigger
                        && tg.getKey().equals("tgroup1.trigger1_1")) {
//						((SimpleTrigger) tg).setRepeatCount(100);
                        scheduler.rescheduleJob(triggerkey,tg);
                    }
                }

            }
            System.out.println("start");
            scheduler.start();
            System.out.println("scheduler end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
