package com.yuan.myquartz;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by yuanxin on 17/9/1.
 */
public class SimpleRecoveryJob  implements Job
{
    private static Logger _log  = LoggerFactory.getLogger(SimpleRecoveryJob.class);

    private static final String COUNT = "count";

    /**
     * Quartz requires a public empty constructor so that the scheduler can instantiate the class whenever it needs.
     */
    public SimpleRecoveryJob() {
    }

    /**
     * <p>
     * Called by the <code>{@link org.quartz.Scheduler}</code> when a <code>{@link org.quartz.Trigger}</code> fires that
     * is associated with the <code>Job</code>.
     * </p>
     *
     * @throws JobExecutionException if there is an exception while executing the job.
     */
    public void execute(JobExecutionContext context) throws JobExecutionException
    {

        JobKey jobKey = context.getJobDetail().getKey();

        // if the job is recovering print a message
        if (context.isRecovering()) {
            _log.info("SimpleRecoveryJob: " + jobKey + " RECOVERING at " + new Date());
        } else {
            _log.info("SimpleRecoveryJob: " + jobKey + " starting at " + new Date());
        }

        // delay for ten seconds
        long delay = 10L * 1000L;
        try {
            Thread.sleep(delay);
        } catch (Exception e) {
            //
        }

        JobDataMap data = context.getJobDetail().getJobDataMap();
        int count;
        if (data.containsKey(COUNT)) {
            count = data.getInt(COUNT);
        } else {
            count = 0;
        }
        count++;
        data.put(COUNT, count);

        _log.info("SimpleRecoveryJob: " + jobKey + " done at " + new Date() + "\n Execution #" + count);

    }
}
