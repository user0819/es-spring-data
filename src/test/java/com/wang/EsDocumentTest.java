package com.wang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsDocumentTest {
    @Autowired
    private ProductDao productDao;

    @Test
    public void save(){
        Product product = new Product(1L,"手机","小米","https://127.0.0.1/images",23.32);
        productDao.save(product);
        System.out.println("保存成功");
    }

    @Test
    public void update(){
        Product product = new Product(1L,"手机test","小米","https://127.0.0.1/images",23.32);
        productDao.save(product);
        System.out.println("修改成功");
    }

    @Test
    public void delete(){
        productDao.deleteById(1L);
        System.out.println("删除成功");
    }

    @Test
    public void batchSave(){
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product((long)i,"手机" + i,"小米","https://127.0.0.1/images",23.32);
            list.add(product);
        }
        productDao.saveAll(list);
        System.out.println("批量保存成功");
    }

    @Test
    public void pageSearch(){
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        int pageNum = 0;
        int size = 5;
        PageRequest of = PageRequest.of(pageNum, size, sort);
        Page<Product> all = productDao.findAll(of);
        all.forEach(System.out::println);
    }

}
