package com.lyj.sc.Design.Proxy.jdkProxy.day1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2023-01-30 14:57
 **/
public class ClothServiceInvocationHandler implements InvocationHandler {

    private Object target;

    public ClothServiceInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(target, args);
        System.out.println("after");
        //返回代理对象
        return result;
    }
}
