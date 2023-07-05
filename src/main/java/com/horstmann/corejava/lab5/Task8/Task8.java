package com.horstmann.corejava.lab5.Task8;

import java.util.concurrent.locks.ReentrantLock;

public class Task8 {

    public static AutoCloseableClass newAutoClosable(){
        AutoCloseableClass result = new AutoCloseableClass(new ReentrantLock());
        return result;
    }
    public static void main(String[] args) {
        try(AutoCloseableClass toClose = newAutoClosable()){
            toClose.lock();
        }
    }
}
