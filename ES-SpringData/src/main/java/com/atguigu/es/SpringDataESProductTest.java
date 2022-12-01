package com.atguigu.es;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
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
public class SpringDataESProductTest {

    @Autowired
    private ProductDao productDao;

    /**
     * 新增
     */
    @Test
    public void save(){
        Product product = new Product();
        product.setId(2L);
        product.setTitle("华为手机");
        product.setCategory("手机");
        product.setPrice(9999.0);
        product.setImages("http://www.atguigu/hw.jpg");
        productDao.save(product);
    }

    @Test
    public void findById(){
        Product product = productDao.findById(2L).get();
        System.out.println(product);
    }

    //查询所有
    @Test
    public void findAll(){
        Iterable<Product> products = productDao.findAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    //批量新增
    @Test
    public void saveAll(){
        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setId(Long.valueOf(i));
            product.setTitle("华为手机");
            product.setCategory("手机");
            product.setPrice(9999.0+i);
            product.setImages("http://www.atguigu/hw.jpg");
            products.add(product);
        }
        productDao.saveAll(products);
    }

    @Test
    public void findByPageable(){
        //分页查询
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        int currentPage=0;
        int pageSize=5;
        //设置查询分页
        PageRequest pageRequest = PageRequest.of(currentPage, pageSize);
        //分页查询
        Page<Product> productPage = productDao.findAll(pageRequest);
        for (Product product : productPage.getContent()) {
            System.out.println(product);
        }
    }
}
