package com.lyj.sc.Design.Proxy.jdkProxy.day1;

import java.lang.reflect.Proxy;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2023-01-30 14:58
 **/
public class ClotheProxy {

    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new ClothServiceInvocationHandler(target));
    }

    public static void main(String[] args) {
        ClotheService proxy =(ClotheService) getProxy(new ClotheServiceImpl());
        proxy.buyCloth("nike");
    }
}
