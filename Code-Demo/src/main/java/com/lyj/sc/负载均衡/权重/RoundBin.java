package com.lyj.sc.负载均衡.权重;

import com.lyj.sc.负载均衡.ServerIps;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-23 15:53
 **/
public class RoundBin {

    public volatile static int pos = 0;
    public static String getServer(){
        if(pos> ServerIps.LIST.size()){
            pos=0;
        }
        String address = ServerIps.LIST.get(pos);
        pos++;
        return address;
    }
}
