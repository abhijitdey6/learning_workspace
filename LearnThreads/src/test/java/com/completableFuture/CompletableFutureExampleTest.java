package com.completableFuture;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompletableFutureExampleTest{

    HelloworldService hws=new HelloworldService();
    CompletableFutureExample completableFutureExample=new CompletableFutureExample(hws);

    @Test
    public void testHelloWorld() {
        CompletableFuture<String> response=completableFutureExample.helloWorld();

        response.thenAccept((result) ->{
            assertEquals("HELLO WORLD",result);
        }).join();
    }

    @Test
    public void testHelloWorldAsync() {
        String response=completableFutureExample.helloWorldAsync();
        assertEquals("HELLO WORLD",response);
    }

    @Test
    public void testHelloWorldAsync3Times() {
        String response=completableFutureExample.helloWorldAsync3Times();
        assertEquals("HELLO WORLDHI COMPLETABLEFUTURE",response);
    }

    @Test
    public void testHelloWorldThenCompose() {
        CompletableFuture<String> response=completableFutureExample.helloWorldThenCompose();

        response.thenAccept((s)->{
            assertEquals("HELLO WORLD",s);
        }).join()
        ;
    }
}