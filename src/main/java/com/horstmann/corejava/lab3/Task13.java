package com.horstmann.corejava.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Task13 {


    private static Runnable runnablesToRunnable(List<Runnable> runnables) {
        return () -> {
            for (Runnable runnable : runnables) {
                runnable.run();
            }
        };
    }

    private static List<Runnable> createRunnablesList() {
        List<Runnable> runnables = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            runnables.add(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Hello, " + finalI);
                    }
                }
            });
        }
        return runnables;
    }

    public static void main(String[] args) {
        List<Runnable> runnables = createRunnablesList();
        runnablesToRunnable(runnables).run();
    }
}