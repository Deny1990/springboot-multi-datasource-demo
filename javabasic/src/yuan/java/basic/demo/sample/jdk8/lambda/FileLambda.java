package yuan.java.basic.demo.sample.jdk8.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by yuanxin on 17/5/25.
 */
public class FileLambda
{
    public static String processFile()
        throws IOException
    {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt")))
        {
            return br.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor p)
        throws IOException
    {

        try (BufferedReader br = new BufferedReader(new FileReader("data.txt")))
        {
            return p.process(br);
        }
    }
}
