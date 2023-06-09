package com.atguigu.dao;

import com.atguigu.bean.Book;

import java.util.List;

/**
 * @Author chenxin
 * @date 2022/3/12
 * @Version 1.0
 */
public interface BookDao {
    List<Book> findAllBook();
    boolean saveBook(Book book);
    boolean deleteBookById(String id);
    Book findBookById(String id);
    boolean updateBook(Book book);
}
