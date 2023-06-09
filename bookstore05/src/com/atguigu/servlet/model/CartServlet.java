package com.atguigu.servlet.model;

import com.atguigu.servlet.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BaseServlet {
    protected void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理加入购物车的请求
        //1. 获得请求参数
        //获得图书的id值
        String id = request.getParameter("id");
        System.out.println("id = " + id);
        //2. 处理业务(不连数据库，所以没有service)

        //3. 给响应
    }

}
