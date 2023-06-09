package com.atguigu.service;

import com.atguigu.bean.Book;

import java.util.List;

/**
 * @Author chenxin
 * @date 2022/3/12
 * @Version 1.0
 */
public interface BookService {
    /**
     * 功能：查询所有图书
     * @return
     */
    List<Book> findAllBook();

    /**
     * 功能：添加图书
     * @param book
     * @return
     */
    boolean saveBook(Book book);

    /**
     * 功能：根据id删除图书信息
     * @param id
     * @return
     */
    boolean deleteBookById(String id);

    /**
     * 功能：根据id查找图书信息
     * @param id
     * @return
     */
    Book findBookById(String id);

    /**
     * 功能：根据书的id修改其他信息
     * @param book
     * @return
     */
    boolean updateBook(Book book);
}
