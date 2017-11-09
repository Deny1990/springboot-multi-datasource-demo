package yuan.java.basic.demo.sample.designmode.decorator;

/**
 * Created by yuanxin on 17/11/9.
 */
public abstract class Decorator extends Component
{
    protected Component component;

    public void setComponent(Component component)
    {
        this.component = component;
    }

    @Override
    public void operation()
    {
        if (component != null)
        {
            component.operation();
        }
    }
}
