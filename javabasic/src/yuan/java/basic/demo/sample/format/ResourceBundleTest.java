package yuan.java.basic.demo.sample.format;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by yuanxin on 17/9/14.
 */
public class ResourceBundleTest
{
    public static void main(String[] args)
    {
        resourceBundleTest();
    }

    private static void test()
    {
        ResourceBundle rb1 = ResourceBundle.getBundle("yuan/java/basic/demo/sample/format/resource", Locale.US);
        ResourceBundle rb2 = ResourceBundle.getBundle("yuan/java/basic/demo/sample/format/resource", Locale.CHINA);
        System.out.println("us" + rb1.getString("greeting.common"));
        System.out.println("cn" + rb2.getString("greeting.common"));
    }

    private static void resourceBundleTest()
    {
        ResourceBundle rb1 = ResourceBundle.getBundle("yuan/java/basic/demo/sample/format/fmt_resource", Locale.US);
        ResourceBundle rb2 = ResourceBundle.getBundle("yuan/java/basic/demo/sample/format/fmt_resource", Locale.CHINA);
        Object[] params = {"John", new GregorianCalendar().getTime()};

        String str1 = new MessageFormat(rb1.getString("greeting.common"), Locale.US).format(params);
        String str2 = new MessageFormat(rb2.getString("greeting.morning"), Locale.CHINA).format(params);
        String str3 = new MessageFormat(rb2.getString("greeting.afternoon"), Locale.CHINA).format(params);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }
}
