package com.company;

import java.util.concurrent.Semaphore;

public class Main {
    static int waiting=0;
    static Semaphore mutex=new Semaphore(1);
    static Semaphore bus=new Semaphore(0);
    static Semaphore boarded=new Semaphore(0);

    public static void main(String[] args) {
        double last_rider_time=System.currentTimeMillis()/1000.0;
        double last_bus_time=System.currentTimeMillis()/1000.0;
        double rider_interval=rider_interval();
        double bus_interval=bus_interval();
        int bus_id=1;
        int rider_id=1;

        while (true){
            if((System.currentTimeMillis()/1000.0)-last_rider_time>=rider_interval){
                new Rider(rider_id).start();
                rider_id++;
                last_rider_time=System.currentTimeMillis()/1000.0;
                rider_interval=rider_interval();
            }

            if((System.currentTimeMillis()/1000.0)-last_bus_time>=bus_interval){
                new Bus(bus_id).start();
                bus_id++;
                last_bus_time=System.currentTimeMillis()/1000.0;
                bus_interval=bus_interval();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(ConsoleColors.RED+"Failed to sleep main thread"+ConsoleColors.RESET);
            }

        }
    }

    //calculates the time interval
    private static double rider_interval(){
        return -20.0 * Math.log(Math.random())/Math.log(2);
    }

    private static double bus_interval(){
        return -1200.0 * Math.log(Math.random())/Math.log(2);
    }
}
