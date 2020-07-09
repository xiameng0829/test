package servlet;

import model.User;
import model.UserDao;
import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program:Maven
 * @description
 * @Author:xiameng
 * @create:2020-07-07 12:27
 **/
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        //1.获取到浏览器提交的用户名和密码
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        if(userName == null || "".equals(userName) || password==null ||"".equals(password)){
            //返回错误页面
            String html =  HtmlGenerator.getMessagePage("用户名或密码不能为空","register.html");
            resp.getWriter().write(html);
            return;
        }
        //2.根据用户名，在数据库查询用户是否存在。存在，提示注册失败
        UserDao userDao = new UserDao();
        User existUser = userDao.selectByName(userName);
        if(existUser != null){
            String html = HtmlGenerator.getMessagePage("用户名已经重复！请更换用户名","register.html");
            resp.getWriter().write(html);
            return;
        }
        //3.根据提交的用户名和密码，构造User对象，并插入到数据库
        User newUser = new User();
        newUser.setName(userName);
        newUser.setPassword(password);
        userDao.add(newUser);
        //4.返回注册成功的页面
        String html = HtmlGenerator.getMessagePage("注册成功","login.html");
        resp.getWriter().write(html);
    }
}
