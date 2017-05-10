package yuan.nio.demo.sample;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by yuanxin on 17/5/9.
 */
public class ChannelTransfromTest
{
    public static void main(String[] args)
    {
        RandomAccessFile fromFile = null;
        try
        {
            fromFile = new RandomAccessFile("/Users/yuanxin/testFile/fromFile.txt", "rw");
            FileChannel fromChannel = fromFile.getChannel();

            RandomAccessFile toFile = new RandomAccessFile("/Users/yuanxin/testFile/toFile.txt", "rw");
            FileChannel      toChannel = toFile.getChannel();

            long position = toChannel.size();
            long count = fromChannel.size();

            toChannel.transferFrom(fromChannel,position, count);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}

