package packaging;

import java.util.Arrays;

/**
 * @program:class
 * @description
 * @Author:xiameng
 * @create:2019-12-03 18:55
 **/
public class Day_3 {
    public static void main(String[] args) {

        /*
        int[] num ={1,2,3,4};
        int[] newnum= Arrays.copyOf(num,3);
        System.out.println(Arrays.toString(newnum));
        */

        //System.arraycopy(原数组名称，原数组开始索引，目标数组名称，目标数组开始索引，拷贝长度);
        /*
        int[] newnum=new int[3];
        System.arraycopy(num,1,newnum,0,3);
        System.out.println(Arrays.toString(newnum));
        */

        //{1,2,3,4,0}-->{1,0,2,3,4}
        int[] num ={1,2,3,4,0};
        System.arraycopy(num,1,num,2,3);
        num[1]=0;
        System.out.println(Arrays.toString(num));

        /*
        //{1,2,3,4,}-->{1,3,4,0}
        System.arraycopy(num,2,num,1,2);
        num[3]=0;
        System.out.println(Arrays.toString(num));
        */
    }
}
