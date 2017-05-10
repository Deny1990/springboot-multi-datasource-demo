package yuan.nio.demo.sample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yuanxin on 17/5/9.
 */
public class SelectorTest
{

    private int ports[];

    private ByteBuffer echoBuffer = ByteBuffer.allocate(1024);

    public SelectorTest(int ports[])
        throws IOException
    {
        this.ports = ports;

        go();
    }

    static public void main(String args[])
        throws Exception
    {

//        System.out.println("channel定义 start");
//        int port = 9999; // the port to listen
//
//        ServerSocketChannel channel = ServerSocketChannel.open(); // here we create a ServerSocketChannel
//        channel.configureBlocking(false); // set channel to non-blocking mode, becareful, FileChannel can not be set to non-blocking mode!
//
//        channel.socket().bind(new InetSocketAddress(port)); // bind address on port
//        Selector selector = Selector.open(); // create a selector
//        SelectionKey selKey = channel.register(selector,
//            SelectionKey.OP_ACCEPT); // regist selector upon channel for interest `accept` event
//
//        int interestSet = selKey.interestOps(); // get interest set
//
//        boolean is_accept = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT;
//
//        System.out.print("isAccept:" + is_accept); // check if is_accept opt is registered
//        System.out.println("channel定义end");
        if (args.length <= 0)
        {
            System.err.println("Usage: java MultiPortEcho port [port port …]");
            System.exit(1);
        }

        int ports[] = new int[args.length];

        for (int i = 0; i < args.length; ++i)
        {
            ports[i] = Integer.parseInt(args[i]);
        }

        new SelectorTest(ports);
    }

    private void go()
        throws IOException
    {
// Create a new selector
        Selector selector = Selector.open();

// Open a listener on each port, and register each one
// with the selector
        for (int i = 0; i < ports.length; ++i)
        {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ServerSocket ss = ssc.socket();
            InetSocketAddress address = new InetSocketAddress(ports[i]);
            ss.bind(address);

            SelectionKey key = ssc.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("Going to listen on " + ports[i]);
        }

        while (true)
        {
            int num = selector.select();

            Set selectedKeys = selector.selectedKeys();
            Iterator it = selectedKeys.iterator();

            while (it.hasNext())
            {
                SelectionKey key = (SelectionKey)it.next();

                if ((key.readyOps() & SelectionKey.OP_ACCEPT)
                    == SelectionKey.OP_ACCEPT)
                {
// Accept the new connection
                    System.out.println("Accept the new connection");
                    ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);

// Add the new connection to the selector
                    System.out.println("Add the new connection to the selector");
                    SelectionKey newKey = sc.register(selector, SelectionKey.OP_READ);
                    it.remove();

                    System.out.println("Got connection from " + sc);
                }
                else if ((key.readyOps() & SelectionKey.OP_READ)
                    == SelectionKey.OP_READ)
                {
// Read the data
                    SocketChannel sc = (SocketChannel)key.channel();

// Echo data
                    int bytesEchoed = 0;
                    while (true)
                    {
                        echoBuffer.clear();

                        int r = sc.read(echoBuffer);

                        if (r <= 0)
                        {
                            break;
                        }

                        echoBuffer.flip();
                        sc.write(echoBuffer);
                        bytesEchoed += r;
                    }

                    System.out.println("Echoed " + bytesEchoed + " from " + sc);

                    it.remove();
                }

            }

            System.out.println("going to clear");
            selectedKeys.clear();
            System.out.println("cleared");
        }
    }
}
