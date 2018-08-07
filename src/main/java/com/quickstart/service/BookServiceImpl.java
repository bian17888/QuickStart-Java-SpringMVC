package com.quickstart.service;

import java.util.ArrayList;
import java.util.List;

import com.quickstart.model.Book;
import org.springframework.stereotype.Service;

/**
 * Created by bian17888 on 2018/8/7.
 */
@Service
public class BookServiceImpl implements BookService {

    public List<Book> findAllBooks () {
        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book();
        book1.setId(1);
        book1.setName("Head First Java");
        book1.setScore(7.2F);
        book1.setLink("https://book.douban.com/subject/4496038/");
        Book book2 = new Book();
        book2.setId(2);
        book2.setName("一个海难幸存者的故事\n");
        book2.setScore(8.2F);
        book2.setLink("https://book.douban.com/subject/27031869/");
        bookList.add(book1);
        bookList.add(book2);

        return bookList;
    }
}
