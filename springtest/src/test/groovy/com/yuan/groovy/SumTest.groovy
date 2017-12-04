package com.yuan.groovy

import spock.lang.Specification

/**
 * Created by yuanxin on 17/12/4.
 */
class SumTest extends Specification {
    void setup() {

    }

    void cleanup() {

    }

    def sum = new Sum();

    def "sum should return param1+param2"() {
        expect:
        sum.sum(1, 1) == 2
    }
}
