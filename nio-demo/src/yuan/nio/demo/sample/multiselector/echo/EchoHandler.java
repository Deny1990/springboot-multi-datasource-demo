package yuan.nio.demo.sample.multiselector.echo;

import yuan.nio.demo.sample.multiselector.Handler;

import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * Created by yuanxin on 17/10/12.
 */
public class EchoHandler extends Handler
{

    EchoHandler(Selector selector, SocketChannel clientChannel){
        super(selector, clientChannel);
    }

    @Override
    public int byteBufferSize() {
        return 1;
    }

    @Override
    public boolean readIsComplete() {
        return readData.length() > 0;
    }

    @Override
    public boolean writeIsComplete() {
        return !writeBuf.hasRemaining();
    }

}
