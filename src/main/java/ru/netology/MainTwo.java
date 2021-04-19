package ru.netology;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class MainTwo {
    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(4);

        //
        Callable<String> stringCallable = new MyCallable();
        Callable<String> stringCallable2 = new MyCallable();
        Callable<String> stringCallable3 = new MyCallable();
        Callable<String> stringCallable4 = new MyCallable();


        /*for (int i = 0; i < 4; i++) {
            Thread.sleep(3000);
            Future<String> future = executor.submit(stringCallable);
            futures.add(future);
        }*/

        List<Callable<String>> callables = List.of(stringCallable, stringCallable2, stringCallable3, stringCallable4);

        String result = executor.invokeAny(callables);
        executor.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);
        //System.out.println("Fast: " + result);
        executor.shutdown();
    }
}
