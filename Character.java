package com.company;

import java.util.Scanner;

/**
 * @program:class
 * @description   将一个字符串中的小写字母变成大写字母，并将大写字母变成小写字母。
 * @Author:xiameng
 * @create:2019-12-02 20:58
 **/
public class Character {
    public static void main(String[] args) {
        String ch="bcdEFG";
        char[] str =ch.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] > 65 && str[i] < 90) {
                str[i] += 32;
            } else {
                str[i] -= 32;
            }
        }
        ch = new String(str);
        System.out.println(ch);
    }
}
