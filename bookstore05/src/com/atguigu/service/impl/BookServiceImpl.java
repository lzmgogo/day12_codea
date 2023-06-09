package com.atguigu.service.impl;

import com.atguigu.bean.Book;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.service.BookService;

import java.util.List;

/**
 * @Author chenxin
 * @date 2022/3/12
 * @Version 1.0
 */
public class BookServiceImpl implements BookService {


    private BookDao bookDao=new BookDaoImpl();
    @Override
    public List<Book> findAllBook() {
        return bookDao.findAllBook();
    }
    @Override
    public boolean saveBook(Book book) {
        return bookDao.saveBook(book);
    }

    @Override
    public boolean deleteBookById(String id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public Book findBookById(String id) {
        return bookDao.findBookById(id);
    }

    @Override
    public boolean updateBook(Book book) {
        return bookDao.updateBook(book);
    }
}
