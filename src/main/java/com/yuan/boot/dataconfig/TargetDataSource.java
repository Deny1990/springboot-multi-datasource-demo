package com.yuan.boot.dataconfig;

import java.lang.annotation.*;

/**
 * Created by yuanxin on 17/4/28.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String name();
}
