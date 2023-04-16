package com.horstmann.corejava.lab3;

public class Task8 {

    public static class Greeter implements Runnable{
        int count;
        String appeal;
        Greeter(int n, String target){
            count = n;
            appeal = target;
        }
        @Override
        public void run() {
            for (int i = 0; i < count; i++){
                System.out.println("Hello" + appeal);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Greeter(10, "Vasya"));
        Thread thread2 = new Thread(new Greeter(10, "Petya"));

        thread1.start();
        thread2.start();
    }
}
