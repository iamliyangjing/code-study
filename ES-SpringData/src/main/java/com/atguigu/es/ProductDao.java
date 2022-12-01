package com.atguigu.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-11-20 23:00
 **/
@Repository
public interface ProductDao extends ElasticsearchRepository<Product,Long> {

}
