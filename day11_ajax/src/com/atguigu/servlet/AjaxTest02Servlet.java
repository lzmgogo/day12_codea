package com.atguigu.servlet;

import com.atguigu.bean.Employee;
import com.atguigu.util.CommonResult;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxTest02Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("访问到了AjaxTest02Servlet");
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //给响应，响应的结果必须是CommonResult对象变成的json字符串
        CommonResult ok = CommonResult.ok().setResultData(new Employee(101, "暗卷", 0, 50000.0));
        //ok内就携带flag的值和resultData的值
        String s = new Gson().toJson(ok);
        System.out.println("s = " + s);
        //需要将s返回
        response.getWriter().write(s);//js那一端，response.data
        //response.data.flag   的值就是请求是否成功的标识
        //response.data.resultData   就是异步请求响应的数据(String,javaBean,list,map..)

    }
}
