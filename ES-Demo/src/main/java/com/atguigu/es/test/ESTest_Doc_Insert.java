package com.atguigu.es.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-11-15 21:09
 **/
public class ESTest_Doc_Insert {
    public static void main(String[] args) throws IOException {
        // 创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //插入数据
        IndexRequest request = new IndexRequest();
        //根据索引 id 插入数据
        request.index("user").id("1001");

        User user = new User();
        user.setName("zhangsan");
        user.setAge("30");
        user.setSex("男");

        //向ES 插入数据，必须将数据转换为JSON格式
        ObjectMapper mapper = new ObjectMapper();

        String userJson = mapper.writeValueAsString(user);

        request.source(userJson, XContentType.JSON);
        //响应结果
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        //查看状态 CREATED
        System.out.println(response.getResult());

    }
}
