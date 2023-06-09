package atlonyan.servlet.ModelServlet;

import atlonyan.bean.Book;
import atlonyan.service.impl.BookServiceImpl;
import atlonyan.servlet.BaseServlet.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BookServlet extends BaseServlet {
    private BookServiceImpl bookService = new BookServiceImpl();
    protected void findAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> allBook = bookService.findAllBook();
        request.setAttribute("books",allBook);
        this.processTemplate("manager/book_manager",request,response);
    }
    protected void toAddBookPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processTemplate("manager/book_add",request,response);
    }


    protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Book book = new Book();
        try {
            BeanUtils.populate(book,parameterMap);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        boolean b = bookService.addBook(book);
        if(b){
            response.sendRedirect(request.getContextPath()+"/book?flag=findAllBook");
        }
    }
    protected void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        boolean b = bookService.deleteBook(id);
        if(b){
            response.sendRedirect(request.getContextPath()+"/book?flag=findAllBook");
        }
    }
    protected void toUpdateBookPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Book bookById = bookService.getBookById(id);
        request.setAttribute("book",bookById);
        processTemplate("manager/book_edit",request,response);
    }

        protected void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Book book = new Book();
            try {
                BeanUtils.populate(book,parameterMap);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            boolean update = bookService.update(book);
            if (update){
                response.sendRedirect(request.getContextPath()+"/book?flag=findAllBook");
            }
        }


}
