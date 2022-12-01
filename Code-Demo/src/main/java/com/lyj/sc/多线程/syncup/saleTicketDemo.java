package com.lyj.sc.多线程.syncup;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-08-26 15:32
 **/
class Ticket{
    private int number=50;
    Object lockObject = new Object();
    public void sale(){
        synchronized (lockObject){
            if(number>0){
                System.out.println(Thread.currentThread().getName()+"卖出第"+number--+"张"+"\t"+"还剩"+number);
            }
        }
    }
}
public class saleTicketDemo {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 0; i < 55; i++) {
                 ticket.sale();
            }
        },"a").start();
        new Thread(()->{
            for (int i = 0; i < 55; i++) {
                ticket.sale();
            }
        },"b").start();
        new Thread(()->{
            for (int i = 0; i < 55; i++) {
                ticket.sale();
            }
        },"c").start();
    }
}
