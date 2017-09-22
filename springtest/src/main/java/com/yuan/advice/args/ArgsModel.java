package com.yuan.advice.args;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by yuanxin on 17/9/21.
 */
@Component
public class ArgsModel {
    Logger logger = LoggerFactory.getLogger(ArgsModel.class);

    public void testParentArgs(ParentModel parentModel) {
        logger.info("入参为{}", parentModel);
    }

    public void testTontModelArgs(ToneModel toneModel) {
        logger.info("testToneModelArgs  入参为:{}",toneModel);
    }
}
