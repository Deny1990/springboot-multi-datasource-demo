package yuan.java.io.demo.test;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yuanxin on 17/7/4.
 */
public class ReadFile
{
    public static void main(String[] args)
        throws FileNotFoundException
    {
        try
        {
            RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
            FileChannel fromChannel = fromFile.getChannel();

            RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
            FileChannel      toChannel = toFile.getChannel();

            long position = 0;
            long count = fromChannel.size();

            fromChannel.transferTo(position, count, toChannel);

            ByteBuffer buffer = ByteBuffer.allocate(128);
            int bytesRead = toChannel.read(buffer);
            while (bytesRead != -1) {

                buffer.flip();  //make buffer ready for read

                while(buffer.hasRemaining()){
                    System.out.print((char) buffer.get()); // read 1 byte at a time
                }

                buffer.clear(); //make buffer ready for writing
                bytesRead = toChannel.read(buffer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
