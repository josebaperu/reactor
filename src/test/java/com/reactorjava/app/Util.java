package com.reactorjava.app;

public class Util {

    public static void waitFor(int secs){
        try {
            Thread.sleep( secs * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static int getInt(){
        return (int) (Math.random() * 10);
    }
}
