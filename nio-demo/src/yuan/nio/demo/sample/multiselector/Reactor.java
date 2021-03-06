package yuan.nio.demo.sample.multiselector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

/**
 * Created by yuanxin on 17/10/12.
 */
public abstract class Reactor extends Thread
{

    Logger log = LoggerFactory.getLogger(Reactor.class);

    protected final int port;

    protected final ServerSocketChannel serverChannel;

    protected final boolean isMainReactor;

    protected final boolean useMultipleReactors;

    protected final long timeout;

    public Selector selector;

    public Reactor(int port, ServerSocketChannel serverChannel, boolean isMainReactor, boolean useMultipleReactors,
        long timeout)
    {
        this.port = port;
        this.serverChannel = serverChannel;
        this.isMainReactor = isMainReactor;
        this.useMultipleReactors = useMultipleReactors;
        this.timeout = timeout;
    }

    @Override
    public void run()
    {
        try
        {
            init();
            while (!Thread.interrupted())
            {
                //不可以使用阻塞的select方式，否则accept后subReactor的selector在register的时候会一直阻塞
                //但是修改为带有超时的select或者selectNow后，subReactor的selector在register就不会阻塞了
                //最终选择了带有超时的select是因为使用selectNow的无限循环会导致CPU飙高特别快
                //并且如果使用阻塞的select方式，还需要知道在哪里调用wakeup，否则会一直阻塞，使用非阻塞方式就不需要wakeup了
                //selector.select();
                //if(selector.selectNow() > 0){
                if (selector.select(timeout) > 0)
                {
                    log.info(selector + " isMainReactor=" + isMainReactor + " select...");
                    Iterator<SelectionKey> keyIt = selector.selectedKeys().iterator();
                    while (keyIt.hasNext())
                    {
                        SelectionKey key = keyIt.next();
                        dispatch(key);
                        keyIt.remove();
                    }
                }
            }
            log.info(getClass().getSimpleName() + " end on " + port + " ..." + "\n");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void init()
        throws IOException
    {
        selector = Selector.open();
        log.info(selector + " isMainReactor=" + isMainReactor);

        if (isMainReactor)
        {
            //serverChannel = ServerSocketChannel.open();
            serverChannel.socket().bind(new InetSocketAddress(port));
            serverChannel.configureBlocking(false);
            SelectionKey key = serverChannel.register(selector, SelectionKey.OP_ACCEPT);
            key.attach(newAcceptor(selector));
            log.info(getClass().getSimpleName() + " start on " + port + " ..." + "\n");
        }
        else
        {

        }

        //如果使用阻塞的select方式，且开启下面的代码的话，相当于开启了多个reactor池，而不是mainReactor和subReactor的关系了
        //SelectionKey key = serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        //key.attach(newAcceptor(selector, serverChannel));
    }

    public abstract Acceptor newAcceptor(Selector selector);

    /**
     * 事件和事件处理器的绑定
     * <ul>
     * <li>管理IO读/写事件到事件处理器的一一对应的绑定</li>
     * </ul>
     */
    private void dispatch(SelectionKey key)
    {
        Runnable r = (Runnable)key.attachment();
        if (r != null)
        {
            r.run();
        }
    }

}
