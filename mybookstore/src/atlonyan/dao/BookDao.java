package atlonyan.dao;

import atlonyan.bean.Book;


import java.util.List;

public interface BookDao {
    List<Book> findAll();
    boolean addBook(Book book);
    boolean delete(String id);
    boolean update(Book book);
    Book getBookById(String id);
}
