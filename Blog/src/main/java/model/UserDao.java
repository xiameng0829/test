package model;

import java.sql.*;

/**
 * @program:Maven
 * @description
 * @Author:xiameng
 * @create:2020-07-06 17:57
 **/
public class UserDao {

    /**
     * 新增用户（用户注册）
     * @param user
     */
    public void add(User user){
        //获取数据库连接
        Connection connection = DBUtil.getConnection();
        String sql = "Insert into user values(null,?,?)";
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getName());
            statement.setString(2,user.getPassword());
            //ret表示这次操作影响到的行数，插入一条记录，返回值为1
            int ret = statement.executeUpdate();
            if(ret!=1){
                throw new SQLException("插入用户信息失败");
            }
            System.out.println("插入用户信息成功");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }


    /**
     * 根据用户名查找用户信息（登录）
     * @param name
     * @return
     */
    public User selectByName(String name){
        Connection connection = DBUtil.getConnection();
        String sql = "select * from user where name=?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            //执行sql
            resultSet = statement.executeQuery();
            //遍历结果集
            if(resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }


    /**
     * 根据用户id查找用户信息
     * @param userId
     * @return
     */
    public User selectById(int userId){
        Connection connection = DBUtil.getConnection();
        String sql = "select * from user where userId=?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            //执行sql
            resultSet = statement.executeQuery();
            //遍历结果集
            if(resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }



    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        //测试add
     /* User user = new User();
      user.setName("admin");
      user.setPassword("123456");
      userDao.add(user);
      */

        //测试selectByName
        User user = userDao.selectByName("admin");
        System.out.println(user);
    }

}
