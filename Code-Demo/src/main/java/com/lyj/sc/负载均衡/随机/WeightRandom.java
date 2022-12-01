package com.lyj.sc.负载均衡.随机;

import com.lyj.sc.负载均衡.ServerIps;

import java.util.Random;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-23 15:35
 **/
public class WeightRandom {

    public static String getServer(){
        Random random = new Random();
        return ServerIps.LIST.get(random.nextInt(ServerIps.LIST.size()));
    }
}
