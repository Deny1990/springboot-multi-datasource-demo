package com.yuan.boot.reactor;

/**
 * Created by yuanxin on 17/5/7.
 */
public class WriteEventHandler extends EventHandler
{
    @Override
    public void handle(Event event) {
        // step 1: encode a message to byte[]
        // step 2: submit a write task to IOWorker thread pool
    }

}
