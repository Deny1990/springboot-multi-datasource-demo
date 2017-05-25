package yuan.java.basic.demo.sample.jdk8.lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by yuanxin on 17/5/25.
 */
@FunctionalInterface
public interface BufferedReaderProcessor
{
    String process(BufferedReader b)throws IOException;
}
