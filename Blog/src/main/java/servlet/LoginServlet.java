package servlet;

import model.User;
import model.UserDao;
import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program:Maven
 * @description
 * @Author:xiameng
 * @create:2020-07-07 12:26
 **/
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        //1.获取用户名和密码
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        if(userName==null || "".equals(userName) || password==null ||"".equals(password)){
            String html = HtmlGenerator.getMessagePage("用户名或密码不能为空","login.html");
            resp.getWriter().write(html);
            return;
        }
        //2.去数据库查询是否存在
        UserDao userDao = new UserDao();
        User user = userDao.selectByName(userName);
        if(user == null || !password.equals(user.getPassword())){
            String html = HtmlGenerator.getMessagePage("用户名或密码错误","login.html");
            resp.getWriter().write(html);
            return;
        }
        //3.登录成功，将用户信息保存在session中
        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("user",user);
        //4.返回登录成功的页面
        String html = HtmlGenerator.getMessagePage("登录成功！","article");
        resp.getWriter().write(html);
    }
}
