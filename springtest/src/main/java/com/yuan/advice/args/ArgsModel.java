package com.yuan.advice.args;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by yuanxin on 17/9/21.
 */
@Component
public class ArgsModel
{
    Logger logger = LoggerFactory.getLogger(ArgsModel.class);
    public void testArgs(ParentModel parentModel)
    {
       logger.info("入参为{}",parentModel);
    }
}
