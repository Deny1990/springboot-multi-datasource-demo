package com.yuan.boot.dataconfig;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by yuanxin on 17/4/28.
 */
public class DynamicDataSource extends AbstractRoutingDataSource
{

    @Override
    protected Object determineCurrentLookupKey()
    {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}
