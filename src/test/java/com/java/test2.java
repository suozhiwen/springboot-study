package com.java;

import com.java.common.test.test2.Person;
import com.java.common.test.test2.Person1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class test2 {

    @Autowired
    private Person person;

    @Autowired
    private Person1 person1;
    @Test
    void test1() {
        System.out.println(person.toString());
//        System.out.println(person.getAge());
//        System.out.println(person.getBirth());
//        System.out.println(person.getBoss());
        System.out.println(person.getLastName());
    }

    @Test
    void test2() {
        System.out.println(person1.toString());
//        System.out.println(person.getAge());
//        System.out.println(person.getBirth());
//        System.out.println(person.getBoss());
        System.out.println(person1.getLastName());
    }
}
