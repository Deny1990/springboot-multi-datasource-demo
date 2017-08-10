package com.yuan.service;

import java.sql.SQLException;

/**
 * Created by yuan on 17/8/7.
 */
public class ForumService {
    public void removeForum(int forumId){
        //do sth
        throw new RuntimeException("运行异常。");
    }

    public void updateForum(int forumId)throws  Exception{
        //do sth
        throw new SQLException("数据更新操作异常。");
    }

}
