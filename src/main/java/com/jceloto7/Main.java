package com.jceloto7;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        int numberOfThreads = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            final int threadNumber = i;
            executorService.execute(() -> {
                long startTime = System.currentTimeMillis();
                performTimeConsumingOperation();
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                System.out.println("Thread " + threadNumber + " took " + elapsedTime + " milliseconds");
            });
        }

        executorService.shutdown();
    }

    private static void performTimeConsumingOperation() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            result.append("a");
        }
    }
}




