package atlonyan.servlet.ModelServlet;

import atlonyan.bean.Book;
import atlonyan.bean.Cart;
import atlonyan.bean.CartItem;
import atlonyan.service.impl.BookServiceImpl;
import atlonyan.servlet.BaseServlet.BaseServlet;
import atlonyan.util.CommonResult;
import com.google.gson.Gson;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CartServlet extends BaseServlet {
    private BookServiceImpl bookService = new BookServiceImpl();
    protected void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
//        System.out.println("id="+id);
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        if(cart==null){
            cart = new Cart();
            session.setAttribute("cart",cart);
        }
        Book book = bookService.getBookById(id);
        cart.addCart(book);
        Integer totalCount = cart.getTotalCount();
        CommonResult commonResult = CommonResult.ok().setResultDate(totalCount);
        String s = new Gson().toJson(commonResult);
        System.out.println("s="+s);
        response.getWriter().write(s);
    }


    protected void toCartPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processTemplate("cart/cart",request,response);
    }
    protected void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        Collection<CartItem> allCartItems = cart.getAllCartItems();
        Integer totalCount = cart.getTotalCount();
        Double totalAmount = cart.getTotalAmount();
        ArrayList list = new ArrayList();
        list.add(allCartItems);
        list.add(totalCount);
        list.add(totalAmount);
        CommonResult commonResult = CommonResult.ok().setResultDate(list);
        String s = new Gson().toJson(commonResult);
        System.out.println(s);
        response.getWriter().write(s);
    }
    protected void clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("cart");
        processTemplate("cart/cart",request,response);
    }
    protected void deleteCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        String id = request.getParameter("id");
        cart.deleteCart(Integer.parseInt(id));
        Collection<CartItem> allCartItems = cart.getAllCartItems();
        Integer totalCount = cart.getTotalCount();
        Double totalAmount = cart.getTotalAmount();
        ArrayList list = new ArrayList();
        list.add(allCartItems);
        list.add(totalCount);
        list.add(totalAmount);
        CommonResult commonResult = CommonResult.ok().setResultDate(list);
        String s = new Gson().toJson(commonResult);
        System.out.println(s);
        response.getWriter().write(s);
    }
    protected void addCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        String id = request.getParameter("id");
        cart.addCount(Integer.parseInt(id));
        showCart(request,response);
    }
    protected void subtractCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        String id = request.getParameter("id");
        cart.subtractCount(Integer.parseInt(id));
        showCart(request,response);
    }
    protected void changeCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        String id = request.getParameter("id");
        String newCount = request.getParameter("newCount");
        cart.changeCount(Integer.parseInt(id),Integer.parseInt(newCount));
        showCart(request,response);
    }
}
