package com.quickstart.service;

import com.quickstart.model.Book;
import java.util.List;

/**
 * Created by bian17888 on 2018/8/7.
 */
public interface BookService {
    List<Book> findAllBooks();
}
