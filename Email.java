package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program:class
 * @description   定义一个正则表达式识别字符串的邮件地址。
 * @Author:xiameng
 * @create:2019-12-02 22:47
 **/
public class Email {
    public static void main(String[] args) {
        String email="abc+123@qq.com.++呵呵呵";
        Pattern p = Pattern.compile("[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+");
        Matcher m = p.matcher(email);
        while(m.find())
        {
            System.out.println(m.group());
        }
    }
}
