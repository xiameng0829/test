package view;

import model.Article;
import model.User;

import java.util.List;

/**
 * @program:Maven
 * @description
 * @Author:xiameng
 * @create:2020-07-07 12:27
 **/
public class HtmlGenerator {
    //拼装一个html表示出错信息
    //message表示错误信息
    //nextUrl表示跳转页面
    public static String getMessagePage(String message, String nextUrl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"utf-8\">");
        stringBuilder.append("<title>提示页面</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<h3>");
        stringBuilder.append(message);
        stringBuilder.append("</h3>");
        stringBuilder.append(String.format("<div><a href=\"%s\"> 接下来点击这里跳转 </a></div>", nextUrl));
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }


    public static String getArticleListPage(User user, List<Article> articles) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"utf-8\">");
        stringBuilder.append("<title>"+"博客列表页"+"</title>");
        stringBuilder.append("</head>");

        stringBuilder.append("<body>");
        stringBuilder.append("<h3>");
        stringBuilder.append("欢迎您！" + user.getName());
        stringBuilder.append("</h3>");
        //循环获取到每个文章的信息，拼装到一起
        for (Article article : articles) {
            //拼接文章标题
            //拼接文章链接
            stringBuilder.append(String.format("<div><a href=\"article?articleId=%d\"> %s </a> " +
                            "<a href=\"article?articleId=%d&delete=1\">删除</a></div>",
                    article.getId(), article.getTitle(),article.getId()));
        }

        //发布文章
        stringBuilder.append("<br>");
        stringBuilder.append("<hr>");
        stringBuilder.append("<br>");

        stringBuilder.append("<div> 发布文章 </div>");
        stringBuilder.append("<form method=\"post\" action=\"article\">");
        //输入标题
        stringBuilder.append("<div><input type=\"text\" style=\"width:50%\" name=\"title\" placeholder=\"请输入标题\"></div>");
        //多行输入框，输入正文
        stringBuilder.append("<div> <textarea name=\"content\" style=\"width:50%; height:500px\"></textarea> </div>");
        //发布按钮
        stringBuilder.append("<div><input type=\"submit\" style=\"width:100px; height:50px\" value=\"发布文章\"></div>");
        stringBuilder.append("</form>");

        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    public static String getArticleDetailPage(User user,User author, Article article) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"utf-8\">");
        stringBuilder.append("<title>博客详情页</title>");
        stringBuilder.append("</head>");

        stringBuilder.append("<body>");
        stringBuilder.append("<h3>");
        stringBuilder.append("欢迎您！" + user.getName());
        stringBuilder.append("</h3>");

        stringBuilder.append("<h1>"+article.getTitle()+"</h1>");
        stringBuilder.append("<h4>"+author.getName()+"</h4>");
        stringBuilder.append("<div>"+article.getContent().replaceAll("\n","<br>")+"</div>");


        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

}
