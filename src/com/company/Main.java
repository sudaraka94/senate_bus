package com.company;

import java.util.concurrent.Semaphore;

public class Main {
    static int waiting=0;
    static Semaphore mutex=new Semaphore(1);
    static Semaphore bus=new Semaphore(0);
    static Semaphore boarded=new Semaphore(0);

    public static void main(String[] args) {
        new Rider().run();
        new Rider().run();
        new Rider().run();
        new Rider().run();
        new Rider().run();
        new Rider().run();
        new Rider().run();
        new Rider().run();
        new Rider().run();
        new Rider().run();
        new Rider().run();
        new Bus().run();
    }
}
