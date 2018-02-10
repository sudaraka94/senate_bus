package com.company;

import java.util.concurrent.Semaphore;

public class Main {
    static int waiting=0;
    static Semaphore mutex=new Semaphore(1);
    static Semaphore bus=new Semaphore(0);
    static Semaphore boarded=new Semaphore(0);

    public static void main(String[] args) {
        Rider r1=new Rider();
        Rider r2=new Rider();
        Bus b1=new Bus();
        r1.start();
        r2.start();
        b1.start();
    }
}
