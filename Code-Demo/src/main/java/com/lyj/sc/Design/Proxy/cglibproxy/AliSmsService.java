package com.lyj.sc.Design.Proxy.cglibproxy;

/**
 * @Author: liyangjing
 * @Date: 2022/05/08/9:05
 * @Description:
 */
public class AliSmsService {
    public  String send(String message){
        System.out.println("send message:   "+message);
        return message;
    }
}
