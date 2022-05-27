package org.example;

public class ThreadHandler  extends Thread{

    private int thread_id;

    public ThreadHandler(int t){
        this.thread_id = t;
    }

    @Override
    public void run(){
        for(int i=0; i<=5; i++){

            System.out.println(thread_id + " - " + i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

}
