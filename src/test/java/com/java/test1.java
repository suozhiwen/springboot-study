package com.java;

import com.java.common.test.test1.Car;
import com.java.common.test.test1.Driver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class test1 {

    @Autowired
    private Car car;

    @Autowired
    private Driver driver;

    @Test
    void test1() {
        boolean result = driver.getCar() == car;
        System.out.println(result ? "同一个car" : "不同的car");
    }
}
