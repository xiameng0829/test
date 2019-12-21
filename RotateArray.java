package code;

/**
 * @program:class
 * @description:
 * 写一个旋转(ar[] , d, n)的函数。数组旋转2次将得到一个数组.
 * @Author:xiameng
 * @create:2019-12-21 18:07
 **/
public class RotateArray {
    public void leftRotate(int arr[],int d,int n){
        for (int i = 0; i < d; i++) {
            leftRotatebyOne(arr,n);
        }
    }
    public void leftRotatebyOne(int arr[],int n){
        int i,temp;
        temp = arr[0];
        for (i = 0; i < n-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[i]=temp;
    }
    public void print(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ,");
        }
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int arr[]={1,2,3,4,5,6,7};
        rotateArray.leftRotate(arr,2,7);
        rotateArray.print(arr);
    }
}
