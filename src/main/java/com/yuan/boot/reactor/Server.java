package com.yuan.boot.reactor;

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
        new Thread(acceptor, "Acceptor-" + acceptor.getPort()).start();
        eventLooper.handleEvents();
    }

}
