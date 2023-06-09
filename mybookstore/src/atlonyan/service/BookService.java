package atlonyan.service;

import atlonyan.bean.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBook();
    boolean addBook(Book book);
    boolean deleteBook(String id);
    boolean update(Book book);
    Book getBookById(String id);
}
