package com.yuan.proxy;

/**
 * Created by yuanxin on 17/8/8.
 */
public class ForumServiceTwoImpl implements ForumServiceTwo
{
    public void removeTopic(int topicId)
    {
        System.out.println("模拟删除topic记录" + topicId);
        try
        {
            Thread.currentThread().sleep(20);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public void removeForum(int forumId)
    {
        System.out.println("模拟删除forumId记录" + forumId);
        try
        {
            Thread.currentThread().sleep(20);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
