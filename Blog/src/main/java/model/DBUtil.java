package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program:Maven
 * @description
 * @Author:xiameng
 * @create:2020-07-06 17:44
 **/
public class DBUtil {
    private static final String url="jdbc:mysql://localhost:3306/blog?charactorEncoding=utf-8&useSSL=true";
    private static final String username="root";
    private static final String password="1234";

    private static volatile DataSource dataSource = null;
    private static DataSource getDataSource(){
        if(dataSource == null){
            synchronized (DBUtil.class){
                if(dataSource == null){
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource) dataSource).setURL(url);
                    ((MysqlDataSource) dataSource).setUser(username);
                    ((MysqlDataSource) dataSource).setPassword(password);
                }
            }
        }
        return dataSource;
    }

    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
