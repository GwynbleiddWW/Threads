package ru.netology;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Random random = new Random();
        int j = random.nextInt(7);
        int i;
        for (i = 0; i < j; i++) {
            Thread.sleep(2000);
            System.out.println("I call!!! " + "Name thread: " + Thread.currentThread().getName());
        }
        return i;
    }
}
