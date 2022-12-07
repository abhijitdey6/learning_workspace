package com.completableFuture;

import threads.util.LoggerUtil;

import java.util.concurrent.CompletableFuture;

import static threads.util.CommonUtil.delay;

public class HelloworldService {

    public String helloWorld(){
        delay(1000);
        return "Hello World";
    }

    public String hello(){
        LoggerUtil.log("Inside hello method:");
        delay(1000);
        return "Hello";
    }

    public String world(){
        LoggerUtil.log("Inside world method:");
        delay(1000);
        return " World";
    }

    public String hi(){
        delay(1000);
        return "hi";
    }

    public CompletableFuture<String> worldFuture(String input){
        LoggerUtil.log("Inside worldFuture method:");
       return CompletableFuture.supplyAsync(()->{
            delay(1000);
            return input+" world";
        });
    }
}
