package com.classpath.helloworld.util;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld{
    public void test(){
        System.out.println("Executing the test method inside the Hello World component");
    }
}