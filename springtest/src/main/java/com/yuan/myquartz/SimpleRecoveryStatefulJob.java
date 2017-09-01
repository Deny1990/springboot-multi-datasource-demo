package com.yuan.myquartz;

import org.quartz.PersistJobDataAfterExecution;
import org.quartz.DisallowConcurrentExecution;

/**
 * Created by yuanxin on 17/9/1.
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class SimpleRecoveryStatefulJob extends SimpleRecoveryJob
{

    public SimpleRecoveryStatefulJob()
    {
        super();

    }
}
