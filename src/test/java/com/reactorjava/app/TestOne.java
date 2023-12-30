package com.reactorjava.app;

import org.junit.Test;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

public class TestOne {

    @Test
    public void testA(){
        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        Stream<String[]> streamOfStringArr  = Stream.of(array);
        streamOfStringArr.flatMap(Stream::of).forEach(System.out::println);
    }
    @Test
    public void testB(){
        Mono<Integer> monoSuccess = Mono.just("hello").map( s -> s.length()/1).log();
        monoSuccess.subscribe(i ->System.out.println("On Next -> " + i ), null, () -> System.out.println("on Complete"));
        System.out.println(" ------ ");
        Mono<Integer> monoByZero = Mono.just("hello").map( s -> s.length()/0).log();
        monoByZero.subscribe(null, error -> System.err.println(error.getMessage()));
    }
}
