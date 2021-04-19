package ru.netology;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName());
        String task = "Hello";
        String task2 = "Man";
        List<String> list = Arrays.asList(task, task2);
        System.out.println(task);
        System.out.println(task2);
        return String.valueOf(list.size());
    }
}
