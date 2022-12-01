package com.lyj.sc.负载均衡;

import java.util.*;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-23 15:30
 **/
public class ServerIps {
    public static final List<String> LIST= Arrays.asList(
            "192.168.0.1",
            "192.168.0.2",
            "192.168.0.3",
            "192.168.0.4",
            "192.168.0.5",
            "192.168.0.6",
            "192.168.0.7",
            "192.168.0.8",
            "192.168.0.9",
            "192.168.0.10"
    );
    public static final Map<String,Integer> WEIGHT_MAP= new LinkedHashMap<>();
    static {
        WEIGHT_MAP.put("192.168.0.1",1);
        WEIGHT_MAP.put("192.168.0.2",2);
        WEIGHT_MAP.put("192.168.0.3",3);
        WEIGHT_MAP.put("192.168.0.4",4);
        WEIGHT_MAP.put("192.168.0.5",5);
        WEIGHT_MAP.put("192.168.0.6",6);
    };
}
