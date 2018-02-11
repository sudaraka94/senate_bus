package com.company;


import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class Bus extends Thread{
    int bus_no;

    public Bus(int no){
        bus_no=no;
    }

    @Override
    public void run() {
        try {
            System.out.println(String.valueOf(ConsoleColors.PURPLE+"Bus No"+String.valueOf(this.bus_no)+" Arrived")+ConsoleColors.RESET);
            Main.mutex.acquire();
            int n=min(Main.waiting,50);

            for (int i=0;i<n;i++){
                Main.bus.release();
                Main.boarded.acquire();
            }

            Main.waiting=max(Main.waiting-50,0);
            Main.mutex.release();
            depart();

        } catch (InterruptedException e) {
            System.out.println(ConsoleColors.RED+"Bus "+String.valueOf(this.bus_no)+" interrupted"+ConsoleColors.RESET);
        }

    }

    private void depart(){
        System.out.println(String.valueOf(ConsoleColors.CYAN+"Bus No"+String.valueOf(this.bus_no)+" is departing")+ConsoleColors.RESET);
    }
}
