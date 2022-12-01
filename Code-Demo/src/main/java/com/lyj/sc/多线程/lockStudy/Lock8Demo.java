package com.lyj.sc.多线程.lockStudy;

import java.util.concurrent.TimeUnit;

/**
 * @Author: liyangjing
 * @Date: 2022/07/31/15:47
 * @Description:
 */
class Phone{
    public synchronized  void sendEmail(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("------sendEmail");
    }

    public static synchronized void sendSMS(){
        System.out.println("---------sendMessage");
    }

    public void  hello(){
        System.out.println("hello");
    }
}

/**
 * 题目：线程操作资源类
 * 8锁案例说明：
 * 1. 标准访问有ab两个线程，请问先打印邮件还是短信  1.邮件 2.短信
 * 2. SendEmail方法种加入了暂停3秒钟，请问先打印邮件还是短信  2.短信 1.邮件  ====上了锁的 一个用户只有一把锁
 * 3. 添加一个普通的hello方法，请问先打印邮件还是hello   1.hello 2.email
 * 4. 有两部手机后，请问先打印哪一个                   1.短信 2.email  // ---------sendMessage
 * ------sendEmail
 * 5. 有两个静态同步方法，有1部手机，请问先打印邮件还是短信
 * 6. 有两个静态同步方法，有2部手机，请问先打印邮件还是短信
 * 7. 有一个静态同步方法，有一个普通同步方法,有1部手机，请问先打印邮件还是短信
 * 8. 有一个静态同步方法，有一个普通同步方法,有2部手机，请问先打印邮件还是短信
 *
 */
public class Lock8Demo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            phone.sendEmail();
        },"a").start();
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            //phone.sendSMS();
            //phone.hello();
            phone2.sendSMS();
        },"b").start();
    }
}
