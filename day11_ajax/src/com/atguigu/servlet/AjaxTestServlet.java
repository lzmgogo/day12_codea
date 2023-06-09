package com.atguigu.servlet;

import com.atguigu.bean.Employee;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AjaxTestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到AjaxTestServlet...");
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        String password = request.getParameter("password");
        System.out.println("password = " + password);
        /*int i=10/0;*/
        //给响应
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //writer.write("success");//谁请求我就写给谁

        //将java对象作为响应数据
        Employee employee=new Employee(101,"科比",0,50000.0);
        //使用json数据作为响应数据(json格式的字符串)
        String str="{\"id\":101,\"name\":\"科比\",\"gender\":0,\"salary\":50000.0}";
        Gson gson=new Gson();
        String s = gson.toJson(employee);
        System.out.println("s = " + s);
        //writer.write(s);
        //将List集合作为响应数据
        List<Employee> list=new ArrayList<>();
        list.add(new Employee(101,"科比",0,50000.0));
        list.add(new Employee(102,"詹姆斯",1,60000.0));
        list.add(new Employee(103,"哈登",0,50000.0));

        String s1 = gson.toJson(list);
        System.out.println("s1 = " + s1);//[{},{},{}]
        //writer.write(s1);
        //将map集合作为响应数据
        Map<String,Employee> map=new HashMap<>();
        map.put("emp01",new Employee(101,"科比",0,50000.0));
        map.put("emp02",new Employee(102,"科比",0,50000.0));
        map.put("emp03",new Employee(103,"科比",0,50000.0));
        String s2 = gson.toJson(map);
        System.out.println("s2 = " + s2);//{emp01:{},emp02:{},emp03:{}}
    }
}
