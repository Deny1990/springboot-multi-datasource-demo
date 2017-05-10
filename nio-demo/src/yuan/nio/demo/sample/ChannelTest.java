package yuan.nio.demo.sample;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yuanxin on 17/5/9.
 */
public class ChannelTest
{
    public static void main(String[] args)
    {
        try
        {
            RandomAccessFile aFile = new RandomAccessFile("/Users/yuanxin/testFile/nio-data.txt", "rw");

            FileChannel inChannel = aFile.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(10);

            int bytesRead = inChannel.read(buf);
            while (bytesRead != -1)
            {

                System.out.println("Read " + bytesRead);
                buf.flip();

                while (buf.hasRemaining())
                {
                    System.out.print((char)buf.get());
                }

                buf.clear();
                bytesRead = inChannel.read(buf);
            }
            aFile.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
