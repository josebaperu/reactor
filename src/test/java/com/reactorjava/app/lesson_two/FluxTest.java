package com.reactorjava.app.lesson_two;

import org.junit.Test;
import reactor.core.publisher.Flux;
import java.util.List;
import java.util.stream.Stream;

public class FluxTest {
    @Test
    public void testA(){
        Flux<Integer> integerFlux = Flux.just(1,2,3,4);
        integerFlux.subscribe(System.out::println);

        Flux<Integer> fromIterable = Flux.fromIterable(List.of(4,8,12,16)).log();
        fromIterable.subscribe(System.out::println);

        Flux<Integer> fromStream = Flux.fromStream(Stream.of(1,2,3,4,5,5,6).distinct());
        fromStream.subscribe(System.out::println);
        //fromStream.subscribe(System.out::println); can not run twice, stream is empty

        Flux<Integer> range = Flux.range(1,10);
        range.subscribe(System.out::println);
    }
}
