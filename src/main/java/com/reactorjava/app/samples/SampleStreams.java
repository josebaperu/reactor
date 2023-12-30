package com.reactorjava.app.samples;

import java.util.stream.Stream;

public class SampleStreams {
    public static Stream<Integer> integersStream (){
        return  Stream.of(1,2,3,4);
    }
    public static Stream<String> stringStream (){
        return  Stream.of("a","b","c","d");
    }
    public static Stream<Integer> intNumbersStream (){
        return  Stream.iterate(0, i-> i+2).limit(10);
    }
    public static Stream<User> userStream (){
        return  Stream.of(new User(1,"a"),new User(2,"b"),new User(3,"c"));
    }
}
