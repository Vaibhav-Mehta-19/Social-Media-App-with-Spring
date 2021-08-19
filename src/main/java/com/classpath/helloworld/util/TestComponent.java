package com.classpath.helloworld.util;

import org.springframework.stereotype.Component;

@Component
public class TestComponent {
    private HelloWorld helloWorld;
    public TestComponent(HelloWorld helloWorld){
        this.helloWorld = helloWorld;
    }
}