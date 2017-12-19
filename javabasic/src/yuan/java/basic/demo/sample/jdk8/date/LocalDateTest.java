package yuan.java.basic.demo.sample.jdk8.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by yuanxin on 17/12/19.
 */
public class LocalDateTest
{
    public static void main(String[] args)
    {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedString = date.format(formatter);
        System.out.println(formattedString);
    }
}
