package com.lyj.sc.Design.Proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Author: liyangjing
 * @Date: 2022/05/08/9:10
 * @Description:
 */
public class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz){
        Enhancer enhancer = new Enhancer();
//        设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
//        设置代理类
        enhancer.setSuperclass(clazz);
//
        enhancer.setCallback(new DebugMethodInterceptor());
        return  enhancer.create();
    }

    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("java");
    }
}
