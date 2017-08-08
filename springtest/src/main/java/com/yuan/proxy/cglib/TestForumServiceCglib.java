package com.yuan.proxy.cglib;

import com.yuan.proxy.ForumServiceTwoImpl;

/**
 * Created by yuanxin on 17/8/8.
 */
public class TestForumServiceCglib
{
    public static void main(String[] args)
    {
        CglibProxy proxy = new CglibProxy();
//        ForumServiceTwoImpl forumServiceTwol = new ForumServiceTwoImpl();
//        proxy.setTarget(forumServiceTwol);
        ForumServiceTwoImpl forumServiceTwo = (ForumServiceTwoImpl)proxy.getProxy(ForumServiceTwoImpl.class);
        forumServiceTwo.removeTopic(2);
        forumServiceTwo.removeForum(22);
    }
}
