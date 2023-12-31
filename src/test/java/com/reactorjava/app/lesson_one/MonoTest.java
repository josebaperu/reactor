package com.reactorjava.app.lesson_one;

import org.junit.Test;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MonoTest {

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
    @Test
    public void testC(){
        Supplier<Integer> integerSupplier = () -> 1;
        Mono<Integer> monoFromSupp = Mono.fromSupplier(integerSupplier);
        monoFromSupp.subscribe(System.out::println);

        Mono<Integer> monoFromRunnable = Mono.fromRunnable(() -> System.out.println("hey from runnable"));
        monoFromRunnable.subscribe();

        Mono<Integer> monoFromFuture = Mono.fromFuture(CompletableFuture.supplyAsync(() -> 10));
        monoFromFuture.subscribe();

        Consumer<Integer> consumerPowerTwo = (i) -> System.out.println(Math.pow(i,2));
        consumerPowerTwo.accept(4);

        Function<Integer, String> stringFunction = (a)->  "hello " + a;
        System.out.println(stringFunction.apply(13));
    }
}
