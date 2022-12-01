package com.atguigu.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
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
public class ESTest_Doc_Insert_Batch {
    public static void main(String[] args) throws IOException {
        // 创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //插入数据 批量
        BulkRequest bulkRequest = new BulkRequest();

        new IndexRequest().index("user").id("1001").source(XContentType.JSON,"name","zhansan");

        bulkRequest.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON,"name","zhansan","age","12","sex","男"));
        bulkRequest.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON,"name","lisi","age","19","sex","男"));
        bulkRequest.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON,"name","wangwu","age","12","sex","男"));
        bulkRequest.add(new IndexRequest().index("user").id("1004").source(XContentType.JSON,"name","liuma","age","13","sex","男"));
        bulkRequest.add(new IndexRequest().index("user").id("1005").source(XContentType.JSON,"name","shuyu","age","12","sex","男"));
        bulkRequest.add(new IndexRequest().index("user").id("1006").source(XContentType.JSON,"name","xiaxiliang","age","16","sex","男"));

        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulkResponse.getTook());
        System.out.println(bulkResponse.getItems());
        restHighLevelClient.close();
    }
}
