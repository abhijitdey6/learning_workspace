package com.completableFuture;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompletableFutureExceptionTest {

    @Mock
    HelloworldService hws=mock(HelloworldService.class);

    @InjectMocks
    CompletableFutureException completableFutureException;

    @Test
    void helloWorldAsyncException() {
        when(hws.hello()).thenThrow(new RuntimeException());
        when(hws.world()).thenCallRealMethod();

        String result=completableFutureException.helloWorldAsyncException();
        assertEquals(" WORLDHI COMPLETABLEFUTURE",result);
    }
    @Test
    void helloWorldAsyncException2() {
        when(hws.hello()).thenThrow(new RuntimeException());
        when(hws.world()).thenThrow(new RuntimeException());

        String result=completableFutureException.helloWorldAsyncException();
        assertEquals("HI COMPLETABLEFUTURE",result);
    }

    @Test
    void helloWorldAsyncException_exceptionally1() {
        when(hws.hello()).thenThrow(new RuntimeException());
        when(hws.world()).thenCallRealMethod();

        String result=completableFutureException.helloWorldAsyncException();
        assertEquals(" WORLDHI COMPLETABLEFUTURE",result);
    }

    @Test
    void helloWorldAsyncException_exceptionally2() {
        when(hws.hello()).thenThrow(new RuntimeException());
        when(hws.world()).thenThrow(new RuntimeException());

        String result=completableFutureException.helloWorldAsyncException();
        assertEquals("HI COMPLETABLEFUTURE",result);
    }
}