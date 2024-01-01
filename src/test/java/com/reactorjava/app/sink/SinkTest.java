package com.reactorjava.app.sink;

import com.reactorjava.app.UtilSubscriber;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class SinkTest {

    UtilSubscriber sub = new UtilSubscriber();

    @Test
    public void test1() {
        Sinks.One<String> sink = Sinks.one();
        Mono<String> mono = sink.asMono();
        mono.subscribe(sub::onNext, sub::onError, () -> sub.onComplete());

        sink.tryEmitValue("hello");
    }

    @Test
    public void test2() {
        Sinks.Many<String> sinks = Sinks.many().multicast().directBestEffort();
        Flux<String> flux = sinks.asFlux();
        Flux<String> flux2 = sinks.asFlux();
        flux.subscribe(sub::onNext, sub::onError, () -> sub.onComplete());
        flux2.subscribe(sub::onNext, sub::onError, () -> sub.onComplete());

        sinks.tryEmitNext("hello");
        sinks.tryEmitNext("hello2");

    }
}
