package com.atguigu.kafka.producer;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * @program: Study-Demo
 * @description: 自定义分区器
 * @author: lyj
 * @create: 2022-11-12 21:39
 **/
public class MyPartitoner implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] bytes, Object value, byte[] bytes1, Cluster cluster) {
        // 获取数据 atguigu hello
        String msgValues = value.toString();
        int partition;

        if(msgValues.contains("atguigu")){
            partition=0;
        }else {
            partition=1;
        }
        return partition;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
