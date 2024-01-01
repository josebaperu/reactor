package com.reactorjava.app;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class UtilSubscriber implements Subscriber<Object> {

    public static void waitFor(int secs) {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getInt() {
        return (int) (Math.random() * 10);
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("onSubscribe " + subscription.toString());

    }

    @Override
    public void onNext(Object o) {
        System.out.println("onNext: " + o);
    }

    @Override
    public void onError(Throwable o) {
        System.out.println("onError: " + o.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete: OK");
    }

    public Runnable onCompleteRunnable = this::onComplete;
}
