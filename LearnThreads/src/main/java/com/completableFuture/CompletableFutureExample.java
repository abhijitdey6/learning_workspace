package com.completableFuture;

import threads.util.LoggerUtil;

import java.util.concurrent.CompletableFuture;

import static threads.util.CommonUtil.delay;
import static threads.util.LoggerUtil.log;

public class CompletableFutureExample {

    private HelloworldService hws;

    public CompletableFutureExample(HelloworldService hws) {
        this.hws = hws;
    }

    public CompletableFuture<String> helloWorld(){
        return CompletableFuture.supplyAsync(hws::helloWorld)
                .thenApply(String::toUpperCase)
               /* .thenAccept((result)->{
                    log(result);
                })*/;
    }

    public String helloWorldAsync(){
        CompletableFuture<String> hello=CompletableFuture.supplyAsync(hws::hello);
        CompletableFuture<String> world=CompletableFuture.supplyAsync(hws::world);

        return hello.thenCombine(world, (h,w)-> h+w)
                .thenApply(String::toUpperCase)
                .join();
    }

    public String helloWorldAsync3Times(){
        CompletableFuture<String> hello=CompletableFuture.supplyAsync(hws::hello);
        CompletableFuture<String> world=CompletableFuture.supplyAsync(hws::world);
        CompletableFuture<String> hi=CompletableFuture.supplyAsync(()->{
            LoggerUtil.log("Inside hi method:");
            delay(1000);
            return "Hi CompletableFuture";
        });

        return hello.thenCombine(world, (h,w)-> h+w)
                .thenCombine(hi,(prev,curr)-> prev+curr)
                .thenApply(String::toUpperCase)
                .join();
    }

    public CompletableFuture<String> helloWorldThenCompose(){
        return CompletableFuture.supplyAsync(hws::hello)
                .thenCompose((prev)->hws.worldFuture(prev))
                .thenApply(String::toUpperCase)
               /* .thenAccept((result)->{
                    log(result);
                })*/;
    }

    public static void main(String[] args) {
        HelloworldService hws=new HelloworldService();

        CompletableFutureExample completableFutureExample=new CompletableFutureExample(hws);
        completableFutureExample.helloWorld().thenAccept((result)->{
            log(result);
        });

        delay(2000);
        System.out.println("Done");
    }
}
