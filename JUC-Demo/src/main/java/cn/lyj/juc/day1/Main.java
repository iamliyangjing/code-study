package cn.lyj.juc.day1;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2023-01-30 10:14
 **/
public class Main {
    public static void main(String[] args) {
        Thread aa = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "come::" + Thread.currentThread().isDaemon());
            while (true) {

            }
        }, "aa");
        aa.start();
        //设置守护线程
        aa.setDaemon(true);
        System.out.println(Thread.currentThread().getName()+"over");
    }
}
