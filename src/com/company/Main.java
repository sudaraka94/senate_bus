package com.company;

import java.util.concurrent.Semaphore;

public class Main {
    static int waiting=0;
    static Semaphore mutex=new Semaphore(1);
    static Semaphore bus=new Semaphore(0);
    static Semaphore boarded=new Semaphore(0);
    static double rider_lambda=(double) 1/ (double) 30; //mean in seconds;
    static double bus_lambda=(double) 1/ (double) 1200; //mean in seconds;

    public static void main(String[] args) {
        double last_rider_time=System.currentTimeMillis()/1000.0;
        double last_bus_time=System.currentTimeMillis()/1000.0;
        double rider_interval=rider_interval();
        double bus_interval=bus_interval();

        while (true){
            if((System.currentTimeMillis()/1000.0)-last_rider_time>=rider_interval){
                System.out.println("rider");
                last_rider_time=System.currentTimeMillis()/1000.0;
                rider_interval=rider_interval();
                System.out.println(rider_interval);
            }

            if((System.currentTimeMillis()/1000.0)-last_bus_time>=bus_interval){
                System.out.println("bus");
                last_bus_time=System.currentTimeMillis()/1000.0;
                bus_interval=bus_interval();
                System.out.println(bus_interval);
            }
        }
    }

    //calculates the time interval
    private static double rider_interval(){
        return rider_lambda*Math.exp((20.0+Math.random()*20.0)*rider_lambda);
    }

    private static double bus_interval(){
        return bus_lambda*Math.exp((1190.0+Math.random()*20.0)*bus_lambda);
    }
}
