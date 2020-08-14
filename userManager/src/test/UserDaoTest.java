package test;

import dao.UserDao;
import entiy.User;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @program:userManager
 * @description
 * @Author:xiameng
 * @create:2020-08-14 15:01
 **/


public class UserDaoTest {
    @Ignore
    @Test
    public void add() {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setName("赞赞");
        user.setUsername("daytoy");
        user.setPassword("123");
        user.setGender("男");
        user.setAge(29);
        user.setAddress("重 庆");
        user.setQq("1234567890");
        user.setEmail("zan@qq.com");
        userDao.add(user);
    }


    @Test
    public void login() {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername("daytoy");
        user.setPassword("123");
        System.out.println(userDao.login(user));
    }

    @Ignore
    @Test
    public void delete() {
        UserDao userDao = new UserDao();
        userDao.delete(11);
    }


    @Test
    public void find() {
        UserDao userDao = new UserDao();
        User user = userDao.find(1);
        System.out.println(user);
    }


    @Test
    public void update() {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setId(6);
        user.setAge(30);
        user.setAddress("北 京");
        user.setQq("126291666");
        user.setEmail("admin@163.com");
        userDao.updateUser(user);
    }


    @Test
    public void findByPage() {
        Map<String,String[]> map = new HashMap<>();
        String[] names={""};
        map.put("name",names);
        String[] addresses={"陕 西"};
        map.put("address",addresses);
        String[] emails={""};
        map.put("email",emails);
        UserDao userDao = new UserDao();
        List<User> userList = userDao.findByPage(0,5,map);
        for (User user:userList) {
            System.out.println(user);
        }
    }


    @Test
    public void findAllRecord() {
        Map<String,String[]> map = new HashMap<>();
        String[] names={""};
        map.put("name",names);
        String[] addresses={""};
        map.put("address",addresses);
        String[] emails={""};
        map.put("email",emails);
        UserDao userDao = new UserDao();
        System.out.println(userDao.findAllRecord(map));
    }
}