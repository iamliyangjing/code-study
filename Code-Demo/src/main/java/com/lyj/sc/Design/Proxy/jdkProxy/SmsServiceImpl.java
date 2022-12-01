package com.lyj.sc.Design.Proxy.jdkProxy;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-16 19:37
 **/
public class SmsServiceImpl implements SmsService{
    @Override
    public String send(String msg) {
        System.out.println("send msg:"+msg);
        return msg;
    }
}
