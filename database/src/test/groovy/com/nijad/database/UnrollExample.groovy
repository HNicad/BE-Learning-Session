package com.nijad.database

import spock.lang.Specification
import spock.lang.Unroll

class UnrollExample extends Specification{
    @Unroll
    def "max of two numbers"(){
        when:
        def r = Math.abs(a)
        then:
        r == b
        where:
        a | b
        -1 | 1
        41 | 41
        -2 | 2
        -6 | 6
        12 | 12
        0 | 0

    }
}
