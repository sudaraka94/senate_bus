package com.company;

public class Rider implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(String.valueOf(Thread.currentThread().getId())+" Started");
            Main.mutex.acquire();
            Main.waiting+=1;
            Main.mutex.release();

            Main.bus.acquire();
            board();
            Main.bus.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void board(){
        System.out.println(String.valueOf(Thread.currentThread().getId())+"Boarding");
    }
}
