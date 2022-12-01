package com.atguigu.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-11-15 21:09
 **/
public class ESTest_Doc_delete {
    public static void main(String[] args) throws IOException {
        // 创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //查询数据（全查询，查询部分）
        DeleteRequest request = new DeleteRequest();
        request.index("user").id("1001");

        //响应结果
        DeleteResponse response = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
        //返回JSON字符串
        System.out.println(response.getResult());
        //关闭客户端

        restHighLevelClient.close();
    }
}
