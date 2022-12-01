package com.atguigu.es;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-11-20 23:06
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataESIndexTest {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    public void createIndex(){
        // 创建索引，系统初始化会自动创建索引
        System.out.println("创建索引");
    }

    @Test
    public void deleteIndex(){
        String flag = elasticsearchRestTemplate.delete(Product.class);
        System.out.println("删除索引="+flag);
    }
}
