package com.horstmann.corejava.lab3;

public class Task9 {
     /*
    Первый метод должен выполнять каждую задачу в отдельном потоке и возвра
щать полученный результат, а второй метод — все методы в текущем потоке и
возвращать полученный результат по завершении последнего метода.
     */

    public static void runTogether(Runnable... tasks){
        for (Runnable task:
             tasks) {
            new Thread(task).start();
        }
    }

    public static void runInOrder(Runnable... tasks){
        for (Runnable task:
                tasks) {
            task.run();
        }
    }

    public static void main(String[] args) {
        Runnable testFunc = () -> {
            System.out.println("Func start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Func end");
        };

        System.out.println("Run in order:");
        runInOrder(testFunc, testFunc, testFunc);

        System.out.println("Run together:");
        runTogether(testFunc, testFunc, testFunc);
    }
}
