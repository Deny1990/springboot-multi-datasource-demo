package yuan.java.basic.demo.sample.format;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by yuanxin on 17/9/14.
 */
public class ResourceBundleTest
{
    public static void main(String[] args)
    {
        ResourceBundle rb1 = ResourceBundle.getBundle("yuan/java/basic/demo/sample/format/resource", Locale.US);
        ResourceBundle rb2 = ResourceBundle.getBundle("yuan/java/basic/demo/sample/format/resource", Locale.CHINA);
        System.out.println("us" + rb1.getString("greeting.common"));
        System.out.println("cn" + rb2.getString("greeting.common"));
    }
}
