package com.reactorjava.app.context;

import com.reactorjava.app.UtilSubscriber;
import org.junit.Test;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

public class ContextTest {
    UtilSubscriber subs = new UtilSubscriber();

    @Test
    public void test1() {
        getMonoMessage().contextWrite(Context.of("key", "value")).subscribe(subs::onNext, subs::onError);
        getMonoMessage().contextWrite(Context.of("null", "null")).subscribe(subs::onNext, subs::onError);

    }

    private Mono<String> getMonoMessage() {
        return Mono.deferContextual(ctx -> {
            if (ctx.hasKey("key"))
                return Mono.just("hey");
            return Mono.error(new RuntimeException("key not found"));
        });
    }
}
