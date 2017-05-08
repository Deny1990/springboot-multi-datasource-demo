package com.yuan.boot.reactor;

import com.yuan.boot.reactor.handler.AcceptEventHandler;
import com.yuan.boot.reactor.handler.ReadEventHandler;
import com.yuan.boot.reactor.handler.WriteEventHandler;
import com.yuan.boot.reactor.model.EventType;
import com.yuan.boot.reactor.model.Source;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yuanxin on 17/5/7.
 */
public class Server
{
    Logger logger = LoggerFactory.getLogger(Server.class);

    Demultiplexer selector = new Demultiplexer();
    EventDispatcher eventLooper = new EventDispatcher(selector);
    Acceptor acceptor;

    public Server(int port) {
        acceptor = new Acceptor(selector, port);
    }

    public void start() {
        eventLooper.registEventHandler(EventType.ACCEPT, new AcceptEventHandler(selector));
        eventLooper.registEventHandler(EventType.READ, new ReadEventHandler(selector));
        eventLooper.registEventHandler(EventType.WRITE, new WriteEventHandler(selector));
        Source source = new Source();
        Source sourcetwo = new Source();
        acceptor.aNewConnection(source);
        acceptor.aNewConnection(sourcetwo);
        logger.info("the source is {}",source);
        new Thread(acceptor, "Acceptor-" + acceptor.getPort()).start();
        eventLooper.handleEvents();
    }

    public static void main(String[] args)
    {
        new Server(9191).start();
    }

}
