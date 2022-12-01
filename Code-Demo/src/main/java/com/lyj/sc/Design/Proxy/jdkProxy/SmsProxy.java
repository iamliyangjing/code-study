package com.lyj.sc.Design.Proxy.jdkProxy;

import java.lang.reflect.Proxy;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-16 19:42
 **/
public class SmsProxy{
    public static Object getProxy(Object target){
        return  Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),new SmsInvocationHandler(target));
    }

    public static void main(String[] args) {
        SmsService smsService = (SmsService) getProxy(new SmsServiceImpl());
        smsService.send("123");
    }
}
