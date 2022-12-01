package com.atguigu.es;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-11-20 23:06
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataESProductGetTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void termQuery(){
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", "小米");
    }
}
