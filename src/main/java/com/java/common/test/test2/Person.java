package com.java.common.test.test2;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Data
@Configuration
public class Person {

    @Value("${person.last-name}")
    private String lastName;

    @Value("${person.age}")
    private Integer age;

    @Value("${person.boss}")
    private Boolean boss;

    @Value("${person.birth}")
    private Date birth;

}