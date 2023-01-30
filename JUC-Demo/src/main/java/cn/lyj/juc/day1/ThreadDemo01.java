package cn.lyj.juc.day1;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2023-01-30 10:43
 **/
// 1. 创建资源类，定义属性和方法
class Share{
    //初始值
    private int number = 0;

    // +1
    public synchronized void incr() throws InterruptedException {
        //判断 干活 通知
        while (number!=0){
            //判断number值是否为0.如果不是0，等待
            this.wait(); // 在哪里睡 就在哪里醒。
        }
        //如果number是0，就+1操作
        number++;
        System.out.println(Thread.currentThread().getName()+"::"+number);
        //通知线程
        this.notifyAll();
    }
    // -1
    public synchronized void decr() throws InterruptedException {
        //判断 干活 通知
        while (number==0){
            //判断number值是否为0.如果不是0，等待
            this.wait();
        }
        //如果number是0，就+1操作
        number--;
        System.out.println(Thread.currentThread().getName()+"::"+number);
        //通知线程
        this.notifyAll();
    }
}
public class ThreadDemo01 {
        // 第三步 创建多个线程，调用资源类的操作方法
        public static void main(String[] args) {
            Share share = new Share();
            //创建线程
            new Thread(()->{
                for (int i = 0; i < 10; i++) {
                    try {
                        share.incr();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            },"AA").start();


            //创建线程
            new Thread(()->{
                for (int i = 0; i < 10; i++) {
                    try {
                        share.decr();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            },"BB").start();

            new Thread(()->{
                for (int i = 0; i < 10; i++) {
                    try {
                        share.incr();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            },"CC").start();

            new Thread(()->{
                for (int i = 0; i < 10; i++) {
                    try {
                        share.decr();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            },"DD").start();
        }
}
