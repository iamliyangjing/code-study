package com.lyj.sc.负载均衡.随机;

import com.lyj.sc.负载均衡.ServerIps;

/**
 * @program: Study-Demo
 * @description: 随机算法
 * @author: lyj
 * @create: 2022-10-23 15:30
 **/
public class Random {

    public static String getServer(){
        java.util.Random random = new java.util.Random();
        return ServerIps.LIST.get(random.nextInt(ServerIps.LIST.size()));
    }

    public static void main(String[] args){
        for (int i=0;i<10;i++){
            System.out.println(getServer());
        }
    }
}
