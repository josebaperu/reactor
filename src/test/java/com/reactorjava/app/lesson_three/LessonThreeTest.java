package com.reactorjava.app.lesson_three;

import com.reactorjava.app.Util;
import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class LessonThreeTest {
    @Test
    public void testOne(){
        getNumbers(5).subscribe(System.out::println);
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
        Util.waitFor(1);
        return Util.getInt();
    }

}
