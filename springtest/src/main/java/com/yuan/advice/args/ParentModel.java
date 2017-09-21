package com.yuan.advice.args;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by yuanxin on 17/9/20.
 */
@Component
@PrintArgs(name = "parmentModel")
public class ParentModel
{
    Logger logger = LoggerFactory.getLogger(ParentModel.class);

    public void methodA(String hello)
    {
        logger.info("parmentModel method");
    }
}
