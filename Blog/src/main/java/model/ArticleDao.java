package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program:Maven
 * @description
 * @Author:xiameng
 * @create:2020-07-06 17:58
 **/
public class ArticleDao {
    /**
     * 添加
     * @param article
     */
    public void add(Article article){
        Connection connection = DBUtil.getConnection();
        String sql = "Insert into Article values(null,?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,article.getTitle());
            statement.setString(2,article.getContent());
            statement.setInt(3,article.getUserId());

            int ret = statement.executeUpdate();
            if(ret != 1){
                throw new SQLException("插入文章失败");
            }
            System.out.println("插入文章成功");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }


    /**
     * 根据文章Id查询文章
     * @param id
     * @return
     */
    public Article selectById(int id){
        Connection connection = DBUtil.getConnection();
        String sql = "select * from article where id=?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setUserId(resultSet.getInt("userId"));
                return article;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }


    /**
     * 显示所有文章信息
     * @return
     */
    public List<Article> selectAll(){
        List<Article> articles = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        String sql = "select * from article";
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setUserId(resultSet.getInt("userId"));
                articles.add(article);
            }
            return articles;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }


    /**
     * 根据文章id删除文章信息
     * @param id
     */
    public void  delete(int id){
        Connection connection  = DBUtil.getConnection();
        String sql = "delete from article where id= ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int ret = statement.executeUpdate();
            if(ret != 1){
                throw new SQLException("删除文章失败");
            }
            System.out.println("删除文章成功");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }




    public static void main(String[] args) {
        ArticleDao articleDao = new ArticleDao();
        //测试add

        /*Article article = new Article();
        article.setTitle("Hello");
        article.setContent("你好");
        article.setUserId(1);
        articleDao.add(article);

        article.setTitle("Today");
        article.setContent("星期二");
        article.setUserId(1);
        articleDao.add(article);*/

        //根据文章id查询
        /*
        Article article = articleDao.selectById(1);
        System.out.println(article);*/


        //查询所有文章
        /*
        List<Article> articles = articleDao.selectAll();
        System.out.println(articles);*/

        //根据文章id删除文章
        articleDao.delete(1);


    }
}
