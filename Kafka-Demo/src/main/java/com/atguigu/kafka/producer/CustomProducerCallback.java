package com.atguigu.kafka.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-11-12 20:49
 **/
public class CustomProducerCallback {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 0. 配置

        Properties properties = new Properties();
        //连接集群
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        // key,value序列化（必须）：key.serializer，value.serializer
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //自定义分区器
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,MyPartitoner.class.getName());
        // 1. 创建kafka生产者对象
        KafkaProducer<String,String> kafkaProducer = new KafkaProducer<String, String>(properties);
        // 2. 发送数据
        for (int i = 0; i < 5; i++) {
            kafkaProducer.send(new ProducerRecord<>("first",0,"0", "lyj" + i), new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e==null){
                        System.out.println("主题"+recordMetadata.topic()+" 分区"+recordMetadata.partition());
                    }
                }
            });
        }
        // 3.关闭资源
        kafkaProducer.close();
    }
}
