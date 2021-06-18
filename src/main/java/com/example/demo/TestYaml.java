package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource(value = "classpath:test.yml", factory = YamlPropertySourceFactory.class)
public class TestYaml {

    @Value("${test.property1.value1}")
    private String value1;

    @Value("${test.property1.value2}")
    private String value2;

    @Value("${test.property2}")
    private String property2;

    @Value("${ignore}")
    private String[] ignore;

    @Value("${test2}")
    private String test2;

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }

    public String[] getIgnore() {
        return ignore;
    }

    public void setIgnore(String[] ignore) {
        this.ignore = ignore;
    }
}
