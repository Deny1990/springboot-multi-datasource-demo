package yuan.nio.demo.sample.multiselector.echo;

import yuan.nio.demo.sample.multiselector.Acceptor;

import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by yuanxin on 17/10/12.
 */
public class EchoAcceptor extends Acceptor
{

    EchoAcceptor(Selector selector, ServerSocketChannel serverChannel, boolean useMultipleReactors){
        super(selector, serverChannel, useMultipleReactors);
    }

    @Override
    public void handle(Selector selector, SocketChannel clientChannel) {
        new EchoHandler(selector, clientChannel).run();
    }

}
