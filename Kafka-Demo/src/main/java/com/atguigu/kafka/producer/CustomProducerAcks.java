
package com.atguigu.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-11-12 20:06
 **/
public class CustomProducerAcks {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 0. 配置

        Properties properties = new Properties();
        //连接集群
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        // key,value序列化（必须）：key.serializer，value.serializer
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // ACKs
        properties.put(ProducerConfig.ACKS_CONFIG,"1");
        //retry times
        properties.put(ProducerConfig.RETRIES_CONFIG,5);
        // 1. 创建kafka生产者对象
        KafkaProducer<String,String> kafkaProducer = new KafkaProducer<String, String>(properties);
        // 2. 发送数据
        for (int i = 0; i < 5; i++) {
            kafkaProducer.send(new ProducerRecord<>("first", "lyj" + i)).get();
        }
        // 3.关闭资源
        kafkaProducer.close();
    }
}
