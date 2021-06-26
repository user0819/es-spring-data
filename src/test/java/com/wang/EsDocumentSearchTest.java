package com.wang;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsDocumentSearchTest {
    @Autowired
    private ProductDao productDao;

    @Test
    public void termsQuery(){
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("category","小米");
        Iterable<Product> products = productDao.search(termQueryBuilder);
        products.forEach(System.out::println);
    }

    @Test
    public void boolQuery(){
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolQuery.must(QueryBuilders.matchQuery("category","小米"));
        Iterable<Product> products = productDao.search(boolQuery);
        products.forEach(System.out::println);
    }

    @Test
    public void termsQueryPage(){
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        int pageNum = 0;
        int size = 5;
        PageRequest of = PageRequest.of(pageNum, size, sort);
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("category","小米");
        Iterable<Product> products = productDao.search(termQueryBuilder,of);
        products.forEach(System.out::println);
    }
}
