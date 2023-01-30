package com.lyj.sc.负载均衡.轮询;

import com.lyj.sc.负载均衡.ServerIps;

/**
 * @program: Study-Demo
 * @description: 普通轮询
 * @author: lyj
 * @create: 2022-10-23 15:53
 **/
public class RoundBin {

    public volatile static int pos = 0;
    public static String getServer(){
        if (pos >= ServerIps.LIST.size()){
            pos=0;
        }
        String ip = ServerIps.LIST.get(pos);
        pos++;

        return ip;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(getServer());
        }
    }
}
