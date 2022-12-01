package com.lyj.sc.Design.Proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-16 19:39
 **/
public class SmsInvocationHandler implements InvocationHandler {

    private Object target;

    public SmsInvocationHandler(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before proxy");
        Object result = method.invoke(target, args);
        System.out.println("after proxy");

        return result;
    }
}
