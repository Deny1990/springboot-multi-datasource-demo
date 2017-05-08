package com.yuan.boot.reactor;

import com.yuan.boot.reactor.model.Event;
import com.yuan.boot.reactor.model.Source;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by yuanxin on 17/5/7.
 */
public class Acceptor implements Runnable
{
    Logger logger = LoggerFactory.getLogger(Acceptor.class);
    private int port; // server socket port
    private Demultiplexer selector;

    // 代表 serversocket
    private BlockingQueue<Source> sourceQueue = new LinkedBlockingQueue<Source>();

    Acceptor(Demultiplexer selector, int port) {
        this.selector = selector;
        this.port = port;
    }

    public void aNewConnection(Source source) {
        sourceQueue.offer(source);
    }

    public int getPort() {
        return this.port;
    }

    public void run() {
        while (true) {

            Source source = null;
            try {
                // 相当于 serversocket.accept()
                logger.info("从soureceQueue 取source");
                source = sourceQueue.take();
            } catch (InterruptedException e) {
                // ignore it;
            }

            if (source != null) {
                logger.info("source不为空");
                Event acceptEvent = new Event();
                acceptEvent.source = source;
                acceptEvent.type = EventType.ACCEPT;
                logger.info("将accept加入selector");
                selector.addEvent(acceptEvent);
            }

        }
    }

}
