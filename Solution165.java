package LeetCode;

/**
 * @program:practice
 * @description ：
 * 比较两个版本号 version1 和 version2：
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 * 假设版本字符串非空，并且只包含数字和 . 字符。
 *  . 字符不代表小数点，而是用于分隔数字序列。
 * 示例：
 * 输入: version1 = "7.5.2.4", version2 = "7.5.3"
 * 输出: -1
 * @Author:xiameng
 * @create:2020-04-09 15:28
 **/
public class Solution165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = (version1.split("\\."));
        String[] v2 = (version2.split("\\."));
        int tmp = Math.min(v1.length,v2.length);
        for (int i = 0; i < tmp; i++) {
            int n1 = Integer.parseInt(v1[i]);
            int n2 = Integer.parseInt(v2[i]);
            if(n1 > n2){
                return 1;
            }else if (n1 < n2){
                return -1;
            }else {
                continue;
            }
        }
        if(v1.length > tmp){
            for (int i = tmp; i < v1.length; i++) {
                int n1 = Integer.parseInt(v1[i]);
                if(n1 !=0){
                    return 1;
                }
            }
        }
        if(v2.length > tmp){
            for (int i = tmp; i < v2.length; i++) {
                int n2 = Integer.parseInt(v2[i]);
                if(n2 != 0){
                    return -1;
                }
            }
        }
        return 0;
    }
}