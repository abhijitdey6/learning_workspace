package com.completableFuture;

import java.util.concurrent.CompletableFuture;

import static threads.util.CommonUtil.delay;
import static threads.util.LoggerUtil.log;

public class CompletableFutureException {

    private HelloworldService hws;

    public CompletableFutureException(HelloworldService hws) {
        this.hws = hws;
    }

    public String helloWorldAsyncException(){
        CompletableFuture<String> hello=CompletableFuture.supplyAsync(hws::hello);
        CompletableFuture<String> world=CompletableFuture.supplyAsync(hws::world);
        CompletableFuture<String> hi=CompletableFuture.supplyAsync(()->{
            delay(1000);
            return "Hi CompletableFuture";
        });

        return hello
                .handle((res,e)->{
                    if(e != null){
                        log("Exception occurred in Hello:"+e.getMessage());
                        return "";
                    }else{
                        return res;
                    }
                })
                .thenCombine(world, (h,w)-> h+w)
                .handle((res,e)->{
                    if(e != null){
                        log("Exception occurred in world:"+e.getMessage());
                        return "";
                    }else{
                        return res;
                    }
                })
                .thenCombine(hi,(prev,curr)-> prev+curr)
                .thenApply(String::toUpperCase)
                .join();
    }

    public String helloWorldAsyncExceptionUsingExceptionally(){
        CompletableFuture<String> hello=CompletableFuture.supplyAsync(hws::hello);
        CompletableFuture<String> world=CompletableFuture.supplyAsync(hws::world);
        CompletableFuture<String> hi=CompletableFuture.supplyAsync(()->{
            delay(1000);
            return "Hi CompletableFuture";
        });

        return hello
                .exceptionally(e->{
                    log("Exception occurred in world:"+e.getMessage());
                    return "";
                })
                .thenCombine(world, (h,w)-> h+w)
                .exceptionally(e->{
                    log("Exception occurred in world:"+e.getMessage());
                    return "";
                })
                .thenCombine(hi,(prev,curr)-> prev+curr)
                .thenApply(String::toUpperCase)
                .join();
    }
}
