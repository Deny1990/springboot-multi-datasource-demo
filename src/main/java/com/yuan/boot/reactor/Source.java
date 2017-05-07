package com.yuan.boot.reactor;

import java.util.Date;

/**
 * Created by yuanxin on 17/5/7.
 */
public class Source
{
        private Date date = new Date();
        private String id = date.toString() + "_" + System.identityHashCode(date);

        @Override
        public String toString() {
            return id;
        }
}
