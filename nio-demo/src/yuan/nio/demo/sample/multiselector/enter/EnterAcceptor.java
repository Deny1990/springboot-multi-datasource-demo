package yuan.nio.demo.sample.multiselector.enter;

import yuan.nio.demo.sample.multiselector.Acceptor;

import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by yuanxin on 17/10/12.
 */
public class EnterAcceptor extends Acceptor
{

    EnterAcceptor(Selector selector, ServerSocketChannel serverChannel, boolean useMultipleReactors){
        super(selector, serverChannel, useMultipleReactors);
    }

    @Override
    public void handle(Selector selector, SocketChannel clientChannel) {
        new EnterHandler(selector, clientChannel).run();
    }

}
