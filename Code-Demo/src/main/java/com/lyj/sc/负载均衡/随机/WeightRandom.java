package com.lyj.sc.负载均衡.随机;

import com.lyj.sc.负载均衡.ServerIps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: Study-Demo
 * @description: 按权重随机
 * @author: lyj
 * @create: 2022-10-23 15:35
 **/
public class WeightRandom {

    public static String getServer(){
        List<String> ips = new ArrayList<>();

        for (String ip : ServerIps.WEIGHT_MAP.keySet()) {
            Integer weight = ServerIps.WEIGHT_MAP.get(ip);

            for (Integer i = 0; i < weight; i++) {
                ips.add(ip);
            }
        }
        Random random = new Random();
        return ips.get(random.nextInt(ips.size()));
    }

    public static void main(String[] args){
        for (int i=0;i<10;i++){
            System.out.println(getServer());
        }
    }
}
