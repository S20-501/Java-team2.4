package com.horstmann.corejava.lab5.Task8;

import java.util.concurrent.locks.ReentrantLock;

public class AutoCloseableClass implements AutoCloseable{
    ReentrantLock lock;

    public AutoCloseableClass(ReentrantLock lock){
        this.lock = lock;
    }

    public void lock(){
        lock.lock();
    }

    @Override
    public void close(){
        lock.unlock();
    }
}
