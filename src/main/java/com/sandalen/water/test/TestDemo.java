package com.sandalen.water.test;

import com.sandalen.water.util.Neo4jUtils;

public class TestDemo {
    public static void testErrJudge(){
        Neo4jUtils.searchErrOrigin("4012");
    }

    public static void main(String[] args) {
        testErrJudge();
    }
}
