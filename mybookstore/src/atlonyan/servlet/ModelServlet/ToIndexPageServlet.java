package atlonyan.servlet.ModelServlet;

import atlonyan.bean.Book;
import atlonyan.servlet.BaseServlet.ViewBaseServlet;
import atlonyan.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ToIndexPageServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookServiceImpl bookService = new BookServiceImpl();
        List<Book> allBook = bookService.findAllBook();
        req.setAttribute("books",allBook);
        processTemplate("index",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
