package com.company;


import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class Bus extends Thread{

    @Override
    public void run() {
        try {
            System.out.println(String.valueOf(Thread.currentThread().getId())+" Started");
            Main.mutex.acquire();
            int n=min(Main.waiting,50);

            for (int i=0;i<n;i++){
                Main.bus.release();
                Main.boarded.acquire();
            }

            Main.waiting=max(Main.waiting-50,0);
            System.out.println(Main.waiting);
            Main.mutex.release();
            depart();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void depart(){
        System.out.println(String.valueOf(Thread.currentThread().getId())+" departed");
    }
}
