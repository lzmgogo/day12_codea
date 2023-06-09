package atlonyan.dao.impl;

import atlonyan.bean.Book;
import atlonyan.dao.BaseDAOImpl;
import atlonyan.dao.BookDao;

import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl extends BaseDAOImpl implements BookDao {
    @Override
    public List<Book> findAll() {
        String sql="Select id bookId,title bookName,author,price,sales,stock,img_path imgPath from books";
        try {
            return this.getList(Book.class,sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addBook(Book book) {
        String sql="INSERT INTO books (title,price,author,sales,stock ) VALUES(?,?,?,?,?)";
        try {
            return update(sql,book.getBookName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock())>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(String id) {
        String sql="delete from books where id=?";
        try {
            return update(sql,id)>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean update(Book book) {
        String sql="UPDATE books SET title=?,author=?,price=?,sales=?,stock=? WHERE id=?";
        try {
            return update(sql,book.getBookName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getBookId())>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book getBookById(String id) {
        String sql="Select id bookId,title bookName,author,price,sales,stock,img_path imgPath from books where id=?";
        try {
            return getBean(Book.class,sql,id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
