package com.lyj.sc.负载均衡.权重;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-23 16:03
 **/
public class RequestId {

    public static volatile int num=0;
    public static int getIncrement(){
        return num++;
    }
}
