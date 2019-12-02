package com.company;

/**
 * @program:class
 * @description   给定一个整数-1234567，输出它的二进制、八进制、十六进制表示形式
 * @Author:xiameng
 * @create:2019-12-02 22:33
 **/
public class Number {
    public static void main(String[] args) {
        int num=-1234567;
        System.out.println("二进制："+Integer.toBinaryString(num));
        System.out.println("八进制："+Integer.toOctalString(num));
        System.out.println("十六进制："+Integer.toHexString(num));
    }
}
