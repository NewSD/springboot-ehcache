package com.niu.dao;

import com.niu.MyKeyGenerator;
import com.niu.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by ami on 2019/6/24.
 */
@Repository
@Service
@CacheConfig(cacheNames = "book_cache")
public class BookDao {

    @Autowired
    MyKeyGenerator myKeyGenerator;

    @Cacheable(keyGenerator = "myKeyGenerator")
    public Book getBookById(Integer id){
        System.out.println("getBookById");
        Book book = new Book();
        book.setId(id);
        book.setName("三国演义111");
        book.setAuthor("罗贯中");
        return book;
    }

    @CachePut(key = "#book.id")
    public Book updateBookById(Book book){
        System.out.println("updateBookById");
        book.setName("红楼梦222");
        return book;
    }

    @CacheEvict(key = "#id")
    public void deleteBookById(Integer id){
        System.out.println("deleteBookById");
    }


}
