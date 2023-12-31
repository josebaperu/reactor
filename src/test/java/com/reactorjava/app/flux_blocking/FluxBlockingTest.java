package com.reactorjava.app.flux_blocking;

import com.reactorjava.app.UtilSubscriber;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class FluxBlockingTest {
    UtilSubscriber sub = new UtilSubscriber();

    @Test
    public void testOne(){
        getNumbers(5).subscribe(sub::onNext);
    }
    @Test
    public void testTwo(){
        getNumbers(5).subscribe(System.out::println);
        getIntList(5).forEach(System.out::println);
    }

    static Flux<Integer> getNumbers(int num){
        return Flux.range(1,num).map(i ->getNumber());
    }
    static List<Integer> getIntList(int num){
        List<Integer> list = new ArrayList<>(num);
        for(int i = 0; i < num;i++){
            list.add(getNumber());
        }
        return list;
    }
    static int getNumber(){
        UtilSubscriber.waitFor(1);
        return UtilSubscriber.getInt();
    }

}
