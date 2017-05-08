package com.yuan.boot.reactor.handler;

import com.yuan.boot.reactor.Demultiplexer;
import com.yuan.boot.reactor.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yuanxin on 17/5/7.
 */
public class WriteEventHandler extends EventHandler
{
    Logger logger = LoggerFactory.getLogger(WriteEventHandler.class);


    private Demultiplexer selector;

    public WriteEventHandler(Demultiplexer selector) {
        this.selector = selector;
    }


    @Override
    public void handle(Event event) {
        // step 1: encode a message to byte[]
        // step 2: submit a write task to IOWorker thread pool
        logger.info("写事件");
    }

}
