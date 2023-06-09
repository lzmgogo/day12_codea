package atlonyan.service.impl;

import atlonyan.bean.Book;
import atlonyan.dao.impl.BookDaoImpl;
import atlonyan.service.BookService;

import java.util.List;


public class BookServiceImpl implements BookService {

    @Override
    public List<Book> findAllBook() {
        BookDaoImpl bookDao = new BookDaoImpl();
        return bookDao.findAll();
    }
    @Override
    public boolean addBook(Book book) {
        BookDaoImpl bookDao = new BookDaoImpl();
        return bookDao.addBook(book);
    }

    @Override
    public boolean deleteBook(String id) {
        BookDaoImpl bookDao = new BookDaoImpl();
        return bookDao.delete(id);
    }

    @Override
    public boolean update(Book book) {
        BookDaoImpl bookDao = new BookDaoImpl();
        return bookDao.update(book);
    }

    @Override
    public Book getBookById(String id) {
        BookDaoImpl bookDao = new BookDaoImpl();
        return bookDao.getBookById(id);
    }

}
