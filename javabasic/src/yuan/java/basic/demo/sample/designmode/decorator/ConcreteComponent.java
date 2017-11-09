package yuan.java.basic.demo.sample.designmode.decorator;

/**
 * Created by yuanxin on 17/11/9.
 */
public class ConcreteComponent extends Component
{
    @Override
    void operation()
    {
        System.out.println("具体的对象的操作");
    }
}
