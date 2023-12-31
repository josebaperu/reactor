package com.reactorjava.app.lesson_one;

import com.reactorjava.app.UtilSubscriber;
import org.junit.Test;
import reactor.core.publisher.Flux;
import java.util.List;
import java.util.stream.Stream;

public class FluxTest {
    UtilSubscriber sub = new UtilSubscriber();
    @Test
    public void testA(){
        Flux<Integer> integerFlux = Flux.just(1,2,3,4);
        integerFlux.subscribe(System.out::println);

        Flux<Integer> fromIterable = Flux.fromIterable(List.of(4,8,12,16)).log();
        fromIterable.subscribe(sub::onNext);

        Flux<Integer> fromStream = Flux.fromStream(Stream.of(1,2,3,4,5,5,6).distinct());
        fromStream.subscribe(sub::onNext);
        //fromStream.subscribe(sub::onNext); //can not run twice, stream is empty


        Flux<Integer> range = Flux.range(1,10);
        range.subscribe(sub::onNext, null, sub.onCompleteRunnable);
    }
}
