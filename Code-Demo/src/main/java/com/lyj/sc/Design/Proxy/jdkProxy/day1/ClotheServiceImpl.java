package com.lyj.sc.Design.Proxy.jdkProxy.day1;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2023-01-30 14:56
 **/
public class ClotheServiceImpl implements ClotheService{
    @Override
    public String buyCloth(String msg) {
        System.out.println("我收到了消息"+msg);
        return "lyj"+msg;
    }
}
