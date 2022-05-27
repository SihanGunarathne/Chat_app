package org.example;

public class MainThread {

    public static  void  main(String[] args){

        ThreadHandler t1 = new ThreadHandler(1);
        ThreadHandler t2 = new ThreadHandler(2);
        t1.start();
        t2.start();
    }
}
