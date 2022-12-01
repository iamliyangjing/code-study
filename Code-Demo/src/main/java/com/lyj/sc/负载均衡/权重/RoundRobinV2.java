package com.lyj.sc.负载均衡.权重;

import com.lyj.sc.负载均衡.ServerIps;
import com.lyj.sc.负载均衡.随机.WeightRandom;

import java.util.Random;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-23 16:03
 **/
public class RoundRobinV2 {


    public static String getServer(){
        int totalOffset = 0;
        for (String s : ServerIps.WEIGHT_MAP.keySet()) {
            Integer weigth = ServerIps.WEIGHT_MAP.get(s);
            totalOffset+=weigth;
        }

        int requestId = RequestId.getIncrement();
        int offset = requestId%totalOffset;

        for (String ip : ServerIps.WEIGHT_MAP.keySet()) {
            Integer weight = ServerIps.WEIGHT_MAP.get(ip);
            if(offset<weight){
                return ip;
            }
            offset=offset-weight;
        }
        return  WeightRandom.getServer();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(getServer());
        }
    }
}
