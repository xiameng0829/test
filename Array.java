package Test;
import java.util.Scanner;
import java.util.Arrays;
/**
 * @program:class
 * @description
 * @Author:xiameng
 * @create:2019-11-28 08:59
 **/
//1.一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
/*
public class Array {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int ret=Frog(n);
        System.out.println("输入台阶数："+n+"\t跳法有："+ret);
     }
    public static int Frog(int n){
        if(n<=0)
        {
            return -1;
        }
        if(n==1)
        {
            return 1;
        }
        else
        {
            return 2*Frog(n-1);
        }
    }
}
*/


//2.输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
/*
public class Array {
    public static void main(String[] args) {
        int[] arr={1,3,2,5,4,6};
        arr(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void arr(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<arr.length-1;j++)
            {
                if(arr[j]%2==0 && arr[j+1]!=0) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
*/


/**
 * 3.把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *  例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

public class Array {
    public static void main(String[] args) {
        int[] arr = {4,6,9,3,5,1};
        sort(arr);
        System.out.println(arr[0]);
    }
    public static int sort(int[] arr){
        if(arr.length==0) {
            return 0;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<arr.length-1;j++)
            {
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr[0];
    }
}






