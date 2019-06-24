package com.niu;

import com.niu.dao.BookDaoRedis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ami on 2019/6/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisClusterAppTests {

    @Autowired
    BookDaoRedis bookDaoRedis;

    @Test
    public void test() {

        bookDaoRedis.getBookById(100);//getBookById
        String book = bookDaoRedis.getBookById(100);
        System.out.println(book);//这本书是三国演义
        bookDaoRedis.updateBookById(100);//updateBookById
        String book2 = bookDaoRedis.getBookById(100);
        System.out.println(book2);//这本书是全新的三国演义
        bookDaoRedis.deleteBookById(100);//deleteBookById
        bookDaoRedis.getBookById(100);//getBookById
        bookDaoRedis.getBookById2(99);//getBookById2
    }

}
