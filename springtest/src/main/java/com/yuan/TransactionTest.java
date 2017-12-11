package com.yuan;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yuanxin on 17/12/6.
 */
public class TransactionTest
{
    public void a()
    {
        System.out.println("aaa");
        b();
    }

    @Transactional
    public void b()
    {
//       更新交易
//       更新订单

    }

    public static void main(String[] args)
    {
        TransactionTest transactionTest = new TransactionTest();
        transactionTest.a();
    }
}
