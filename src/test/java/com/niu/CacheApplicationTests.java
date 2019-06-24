package com.niu;

import com.niu.dao.BookDao;
import com.niu.entity.Book;
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
public class CacheApplicationTests {

    @Autowired
    BookDao bookDao;

    @Test
    public void test() {
        bookDao.getBookById(1);//getBookById
        bookDao.getBookById(1);
        bookDao.deleteBookById(1);//deleteBookById
        Book b3 = bookDao.getBookById(1);//getBookById
        System.out.println("b3:" + b3);//b3:Book(id=1, name=三国演义, author=罗贯中)
        Book b = new Book();
        b.setName("三国演义666");
        b.setAuthor("罗贯中");
        b.setId(1);
        bookDao.updateBookById(b);//updateBookById
        Book b4 = bookDao.getBookById(1);
        System.out.println("b4:" + b4);


    }
}
