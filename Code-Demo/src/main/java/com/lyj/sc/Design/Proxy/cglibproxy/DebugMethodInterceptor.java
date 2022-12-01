package com.lyj.sc.Design.Proxy.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: liyangjing
 * @Date: 2022/05/08/9:06
 * @Description:
 */
public class DebugMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before  :"+method.getName());
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("after :"+method.getName());
        return o1;
    }
}
