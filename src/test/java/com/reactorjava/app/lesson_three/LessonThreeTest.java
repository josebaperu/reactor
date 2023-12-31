package com.reactorjava.app.lesson_three;

import com.reactorjava.app.UtilSubscriber;
import org.junit.Test;
import reactor.core.publisher.Flux;

public class LessonThreeTest {
    UtilSubscriber sub = new UtilSubscriber();

    @Test
    public void test1(){

        Flux.create(fluxSink -> {
            fluxSink.next(1);
            fluxSink.next(2);
            fluxSink.complete();
        }).subscribe(sub::onNext, null, sub.onCompleteRunnable);

    }
}
