package yuan.java.basic.demo.sample.jdk8.completablefuture;

/**
 * Created by yuanxin on 17/6/15.
 */
public class Quote
{
    private String shopName;

    private double price;

    private Discount.Code discountCode;

    public Quote(String shopName, double price,
        Discount.Code discountCode)
    {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = discountCode;
    }

    public static Quote parse(String s)
    {
        System.out.println("parse thread is "+Thread.currentThread());
        String[] split = s.split(":");
        String shopName = split[0];
        double price = Double.parseDouble(split[1]);
        Discount.Code discountCode = Discount.Code.valueOf(split[2]);
        return new Quote(shopName, price, discountCode);
    }

    public String getShopName()
    {
        return shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public Discount.Code getDiscountCode()
    {
        return discountCode;
    }

    public void setDiscountCode(Discount.Code discountCode)
    {
        this.discountCode = discountCode;
    }

    @Override
    public String toString()
    {
        final StringBuffer sb = new StringBuffer("Quote{");
        sb.append("shopName='").append(shopName).append('\'');
        sb.append(", price=").append(price);
        sb.append(", discountCode=").append(discountCode);
        sb.append('}');
        return sb.toString();
    }
}
