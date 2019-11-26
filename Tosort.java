package Test;

import java.util.Arrays;

/**
 * @program:class
 * @description  数组排序(冒泡排序)
 * @Author:xiameng
 * @create:2019-11-26 20:03
 **/
public class Tosort {
    public static void main(String[] args) {
        int[] arr= {2,1,4,3,8,5};
        sort(arr);
        tosort(arr);
        order(arr);
        System.out.println(Arrays.toString(arr));
    }

    //冒泡排序
    public static void sort(int[] arr) {
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    //数组逆序
    public static void tosort(int[] arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }

    //给定一个整型数组, 将所有的偶数放在前半部分, 将所有的奇数放在数组后半部
    public static void order(int[] arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            while(left<right && arr[left]%2==0)
            {
                left++;
            }
            while(left<right && arr[right]%2!=0)
            {
                right--;
            }
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
        }
    }
}
