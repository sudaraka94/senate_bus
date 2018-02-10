package com.company;

public class Rider extends Thread{
    @Override
    public void run() {
        try {
            System.out.println(String.valueOf(Thread.currentThread().getId())+" Started");
            Main.mutex.acquire();
            Main.waiting+=1;
            Main.mutex.release();

            Main.bus.acquire();
            board();
            Main.boarded.release();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void board(){
        System.out.println(String.valueOf(Thread.currentThread().getId())+" Boarding");
    }
}
