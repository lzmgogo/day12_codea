package test.java;

import atlonyan.bean.Book;
import atlonyan.dao.impl.BookDaoImpl;
import org.junit.Test;

import java.util.List;

public class BookDaoImplTest {
    @Test
    public void test01(){
        BookDaoImpl bookDao = new BookDaoImpl();
        List<Book> all = bookDao.findAll();
        for (Book book : all) {
            System.out.println(book);
        }
    }
}
