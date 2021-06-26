package com.wang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsIndexTest {
    @Autowired
    private ElasticsearchRestTemplate restTemplate;

    @Test
    public void createIndex(){
        System.out.println("听说可以自动创建索引");
    }

    @Test
    public void deleteIndex(){
        restTemplate.deleteIndex(Product.class);
        System.out.println("删除索引Product");
    }
}
