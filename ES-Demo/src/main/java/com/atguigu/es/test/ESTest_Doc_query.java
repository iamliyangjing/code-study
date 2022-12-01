package com.atguigu.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-11-15 21:09
 **/

public class ESTest_Doc_query {
    public static void main(String[] args) throws IOException {
        // 创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

//        //1. 查询数据
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
//
//        SearchResponse response = restHighLevelClient.search(request,RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }


//        //2. 条件查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("name","lisi")));
//
//        SearchResponse response = restHighLevelClient.search(request,RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        //3. 分页查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //分页  （当前页面-1）*每页显示条数
//        searchSourceBuilder.from(0);
//        searchSourceBuilder.size(3);
//        request.source(searchSourceBuilder);
//
//        SearchResponse response = restHighLevelClient.search(request,RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 4. 查询排序
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        searchSourceBuilder.sort("age",SortOrder.ASC);
//        request.source(searchSourceBuilder);
//
//        SearchResponse response = restHighLevelClient.search(request,RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        //5. filter statitics
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //排除
//        String[] excludes = {"age"};
//        //包含
//        String[] includes = {};
//        searchSourceBuilder.fetchSource(includes,excludes);
//        request.source(searchSourceBuilder);
//
//        SearchResponse response = restHighLevelClient.search(request,RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        //6 compose query
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        // 必要条件
//        boolQueryBuilder.must(QueryBuilders.matchQuery("age","18"));
//        boolQueryBuilder.must(QueryBuilders.matchQuery("sex","男"));
//
//        searchSourceBuilder.query(boolQueryBuilder);
//        // source  request 组装Builder
//        request.source(searchSourceBuilder);
//        //搜索
//        SearchResponse response = restHighLevelClient.search(request,RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 7.should compose query
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        // 必要条件
////        boolQueryBuilder.must(QueryBuilders.matchQuery("age","18"));
////        boolQueryBuilder.must(QueryBuilders.matchQuery("sex","男"));
//        // should 查询
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age","18"));
//        // age should
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age","19"));
//        searchSourceBuilder.query(boolQueryBuilder);
//        // source  request 组装Builder
//        request.source(searchSourceBuilder);
//        //搜索
//        SearchResponse response = restHighLevelClient.search(request,RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 8.range query
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        RangeQueryBuilder age = QueryBuilders.rangeQuery("age");
//        //大于等于
//        age.gte("15");
//        //小于等于
//        age.lte("25");
//        // 必要条件
//        searchSourceBuilder.query(age);
//        // source  request 组装Builder
//        request.source(searchSourceBuilder);
//        //搜索
//        SearchResponse response = restHighLevelClient.search(request,RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 9.模糊查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        FuzzyQueryBuilder fuzziness = QueryBuilders.fuzzyQuery("name", "wangwu").fuzziness(Fuzziness.ONE);
//
//        // 必要条件
//        searchSourceBuilder.query(fuzziness);
//        // source  request 组装Builder
//        request.source(searchSourceBuilder);
//        //搜索
//        SearchResponse response = restHighLevelClient.search(request,RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        //10.高亮查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "lisi");
//
//        //高亮设置
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        //设置高亮
//        highlightBuilder.preTags("<font color='red'>");
//        highlightBuilder.postTags("</font>");
//        highlightBuilder.field("name");
//        searchSourceBuilder.highlighter();
//        searchSourceBuilder.query(termQueryBuilder);
//        // source  request 组装Builder
//        request.source(searchSourceBuilder);
//        //搜索
//        SearchResponse response = restHighLevelClient.search(request,RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 11.聚合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//
//        AggregationBuilder aggregationBuilder = AggregationBuilders.max("maxAge").field("age");
//        searchSourceBuilder.aggregation(aggregationBuilder);
//
//        // source  request 组装Builder
//        request.source(searchSourceBuilder);
//        //搜索
//        SearchResponse response = restHighLevelClient.search(request,RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        //12.分组查询

        SearchRequest request = new SearchRequest();
        request.indices("user");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        AggregationBuilder aggregationBuilder = AggregationBuilders.terms("ageGroup").field("sex");
        searchSourceBuilder.aggregation(aggregationBuilder);

        // source  request 组装Builder
        request.source(searchSourceBuilder);
        //搜索
        SearchResponse response = restHighLevelClient.search(request,RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
        restHighLevelClient.close();
    }
}
