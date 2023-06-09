package atlonyan.servlet.ModelServlet;

import atlonyan.bean.User;
import atlonyan.service.impl.UserServiceImpl;
import atlonyan.servlet.BaseServlet.BaseServlet;
import atlonyan.util.CommonResult;
import com.google.gson.Gson;
import com.sun.prism.null3d.NULL3DPipeline;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class UserServlet extends BaseServlet {
    protected void toRegistPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processTemplate("user/regist", request, response);
    }
    protected void toLoginPage(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        processTemplate("user/login",request,response);
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        System.out.println("code="+code);
        Object kaptchaSessionKey = request.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        System.out.println("kaptchaSessionKey="+kaptchaSessionKey);
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        if (kaptchaSessionKey.equals(code)){
            try {
                BeanUtils.populate(user,parameterMap);
            } catch (Exception e)  {
                throw new RuntimeException(e);
            }
//        UserDaoImpl userDao = new UserDaoImpl();
//        String encode = MD5Util.encode(user.getPassword());
//        user.setPassword(encode);
//        boolean b = userDao.addUser(user);
            UserServiceImpl userService = new UserServiceImpl();
            boolean regist = userService.regist(user);
            String username = request.getParameter("username");
            request.setAttribute("username",username);
            if(regist){
                processTemplate("user/regist_success",request,response);
            }
        }else {
            request.setAttribute("user",user);
            request.setAttribute("code",code);
            request.setAttribute("codeErrMsg","验证码错误");
            processTemplate("user/regist",request,response);
        }
    }
    protected void login(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        UserServiceImpl userService = new UserServiceImpl();
        boolean login = userService.login(user);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("password",password);
        request.getSession().setAttribute("username",username);
        request.setAttribute("errMsg","用户名或者密码错误");
        if(login){
            processTemplate("user/login_success",request,response);
        }else {
            processTemplate("user/login",request,response);
        }
    }
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath()+"/index.html");
    }
    protected void checkUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        UserServiceImpl userService = new UserServiceImpl();
        User userByUsername = userService.getUserByUsername(username);
        CommonResult ok=null;
        if(userByUsername==null){
            ok=CommonResult.ok();
        }else {
            ok=CommonResult.error();
        }
        String s = new Gson().toJson(ok);
        System.out.println("s="+s);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(s);
    }
}
