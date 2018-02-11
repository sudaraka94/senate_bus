package com.company;

public class Rider extends Thread{
    int rider_no;

    public Rider(int no){
        rider_no=no;
    }
    @Override
    public void run() {
        try {
            System.out.println(String.valueOf(ConsoleColors.BLUE+"Rider No"+String.valueOf(this.rider_no)+" Arrived")+ConsoleColors.RESET);
            Main.mutex.acquire();
            Main.waiting+=1;
            Main.mutex.release();

            Main.bus.acquire();
            board();
            Main.boarded.release();


        } catch (InterruptedException e) {
            System.out.println(ConsoleColors.RED+"Rider "+String.valueOf(this.rider_no)+" interrupted"+ConsoleColors.RESET);
        }
    }

    private void board(){
        System.out.println(String.valueOf(ConsoleColors.GREEN+"Rider No"+String.valueOf(this.rider_no)+" is bording")+ConsoleColors.RESET);
    }
}
