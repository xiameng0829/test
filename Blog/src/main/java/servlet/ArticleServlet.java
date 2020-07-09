package servlet;

import model.Article;
import model.ArticleDao;
import model.User;
import model.UserDao;
import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @program:Maven
 * @description
 * @Author:xiameng
 * @create:2020-07-08 19:37
 **/
public class ArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        //1.验证是否登录，如果没登录，要求先登录才能查看
        //(验证session是否存在)
        HttpSession httpSession = req.getSession(false);
        if(httpSession == null){
            String html  = HtmlGenerator.getMessagePage("您尚未登录，无法查看文章列表","login.html");
            resp.getWriter().write(html);
            return;
        }
        User user = (User) httpSession.getAttribute("user");
        //2.区分当前是获取文章列表，还是获取指定文章内容
        String articleId = req.getParameter("articleId");

        String delete = req.getParameter("delete");
        if(delete != null && !"".equals(delete)){
            deleteArticle(articleId,user,resp);
        }else if(articleId == null || "".equals(articleId)){
            //3.获取所有文章列表
            getAllArticle(user,resp);
        }else {
            //4.获取指定文章内容
            getOneArticle(Integer.parseInt(articleId),user,resp);
        }


    }

    //删除文章
    private void deleteArticle(String articleId, User user, HttpServletResponse resp) throws IOException {
        //1.验证参数
        if(articleId == null){
            String html  = HtmlGenerator.getMessagePage("文章Id非法","article");
            resp.getWriter().write(html);
            return;
        }
        int id = Integer.parseInt(articleId);
        //2.从数据库查找文章信息
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.selectById(id);
        if(article==null){
            String html  = HtmlGenerator.getMessagePage("删除的文章不存在","article");
            resp.getWriter().write(html);
            return;
        }
        //3.验证用户信息（只能删除自己的）
        if(article.getUserId() != user.getUserId()){
            String html  = HtmlGenerator.getMessagePage("您无法删除别人的文章","article");
            resp.getWriter().write(html);
            return;
        }
        //4.删除
        articleDao.delete(id);
        //5.返回删除成功的页面
        String html  = HtmlGenerator.getMessagePage("删除成功","article");
        resp.getWriter().write(html);
        return;

    }


    private void getAllArticle(User user,HttpServletResponse resp) throws IOException {
        //从数据库查找文章数据
        ArticleDao articleDao = new ArticleDao();
        List<Article> articles = articleDao.selectAll();

        String html = HtmlGenerator.getArticleListPage(user,articles);
        resp.getWriter().write(html);
        return;
    }


    private void getOneArticle(int articleId,User curUser,HttpServletResponse resp) throws IOException {
        //从数据库查找文章数据
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.selectById(articleId);
        if(article == null){
            //没有查到对应的文章，返回文章列表页
            String html = HtmlGenerator.getMessagePage("您想查看的文章不存在","article");
            resp.getWriter().write(html);
            return;
        }

        //根据用户Id查找对应的作者名
        UserDao userDao = new UserDao();
        User author = userDao.selectById(article.getUserId());

        String html = HtmlGenerator.getArticleDetailPage(curUser,author,article);
        resp.getWriter().write(html);

    }




    //处理发布文章
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        req.setCharacterEncoding("utf-8");
        //1.判断是否登录,如果未登录，需提示先登录才能发布文章
        HttpSession httpSession = req.getSession(false);
        if(httpSession == null){
            String html = HtmlGenerator.getMessagePage("您尚未登录","login.html");
            resp.getWriter().write(html);
            return;
        }
        User user = (User) httpSession.getAttribute("user");
        //2.如果登录成功，获取客户端提交的标题和正文
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if(title == null || content == null ||"".equals(title) || "".equals(content)){
            String html = HtmlGenerator.getMessagePage("提交的内容有误","article");
            resp.getWriter().write(html);
            return;
        }
        //3/构造一个Article对象，插入到数据库中
        ArticleDao articleDao = new ArticleDao();
        Article article = new Article();
        article.setUserId(user.getUserId());
        article.setTitle(title);
        article.setContent(content);
        articleDao.add(article);
        //4.返回一个提示页面，发布成功
        String html = HtmlGenerator.getMessagePage("发布文章成功","article");
        resp.getWriter().write(html);
    }
}

