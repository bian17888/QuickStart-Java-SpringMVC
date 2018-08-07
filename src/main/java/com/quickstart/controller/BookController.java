package com.quickstart.controller;

import java.util.ArrayList;
import java.util.List;

import com.quickstart.model.Book;
import com.quickstart.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by bian17888 on 2018/8/5.
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    private List<Book> bookList;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String findAllBooks(Model model) {

        // 初始化
        if (this.bookList == null) {
            this.bookList = bookService.findAllBooks();
        }

        model.addAttribute("bookList", this.bookList);

        return "books";
    }

    /**
     * GET 新建 or 编辑书目
     *
     * @return
     */
    @RequestMapping(value = "/books/edit", method = RequestMethod.GET)
    public String editBook(
            @RequestParam(value = "id", required = false, defaultValue = "0") Integer id,
            Model model
    ) {
        if (id > 0) {
            for (Book book : this.bookList) {
                if (book.getId() == id) {
                    model.addAttribute("book", book);
                    break;
                }
            }
        } else {
            Book book = new Book();
            model.addAttribute("book", book);
        }
        return "editBook";
    }

    /**
     * POST 新建 or 编辑书目
     *
     * @return
     */
    @RequestMapping(value = "/books/edit", method = RequestMethod.POST)
    public String addBook(
            @Valid @ModelAttribute("book") Book book,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "editBook";
        }
        // 编辑
        if (book.getId() != null) {
            for (Book current : this.bookList) {
                if (book.getId() == current.getId()) {
                    current.setName(book.getName());
                    current.setScore(book.getScore());
                    current.setLink(book.getLink());
                    break;
                }
            }
        } else {
            book.setId(this.bookList.size() + 1);
            this.bookList.add(book);
        }
        return "redirect:/books.html";
    }

    /**
     * POST 删除书目
     *
     * @return
     */
    @RequestMapping(value = "/books/delete/{id}", method = RequestMethod.POST)
    public String deleteBook(
            @PathVariable("id") Integer id
    ) {
        for (Book book : this.bookList) {
            if (book.getId() == id) {
                this.bookList.remove(book);
                break;
            }
        }
        return "redirect:/books.html";
    }
}
