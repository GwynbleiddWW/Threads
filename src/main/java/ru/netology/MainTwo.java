package ru.netology;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTwo {
    public static void main(String[] args) throws Exception {

        Callable<Integer> callableOne = new MyCallable();
        Callable<Integer> callableTwo = new MyCallable();
        Callable<Integer> callableThree = new MyCallable();
        Callable<Integer> callableFour = new MyCallable();
        Callable<Integer> callableFive = new MyCallable();

        ExecutorService executor = Executors.newFixedThreadPool(4);

        System.out.println("Number of messages: " + executor.submit(callableOne).get());

        List<Callable<Integer>> callables = Arrays.asList(callableOne, callableTwo,
                callableThree, callableFour, callableFive);

        System.out.println("All:");
        executor.invokeAll(callables);
        System.out.println("Fasted: " + executor.invokeAny(callables));

        executor.shutdown();
    }
}
