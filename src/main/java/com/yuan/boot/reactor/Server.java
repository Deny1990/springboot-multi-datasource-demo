package com.yuan.boot.reactor;

import com.yuan.boot.reactor.handler.AcceptEventHandler;
import com.yuan.boot.reactor.handler.ReadEventHandler;
import com.yuan.boot.reactor.handler.WriteEventHandler;
import com.yuan.boot.reactor.model.Source;

/**
 * Created by yuanxin on 17/5/7.
 */
public class Server
{
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
        acceptor.aNewConnection(new Source());
        new Thread(acceptor, "Acceptor-" + acceptor.getPort()).start();
        eventLooper.handleEvents();
    }

}
