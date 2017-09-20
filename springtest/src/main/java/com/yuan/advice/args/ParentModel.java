package com.yuan.advice.args;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by yuanxin on 17/9/20.
 */
@Component
public class ParentModel
{
    Logger logger = LoggerFactory.getLogger(ParentModel.class);

    public void methodA(@PrintArgs(name = "parentMehod") String name)
    {
        logger.info("parmentModel method");
    }
}
