package Test;

import java.util.Arrays;
/*
//arr—>String
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        String newArr = Arrays.toString(arr);
        System.out.println(newArr);
    }
}
*/

/*
//将数组中的每个元素都 *2
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] output=doubleArray(arr);
        printArray(output);
    }
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
    public static int[] doubleArray(int[] arr){
        int[] ret =new int[arr.length];
        for(int i=0;i<arr.length;i++){
            ret[i] = arr[i]*2;
        }
        return ret;
    }
}
*/


/*
//求数组中元素的平均值
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(avg(arr));
    }
    public static double avg(int[] arr) {
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        return (double) sum / (double) arr.length;
    }
}
*/



//求数组中的最大元素
public class Main{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(max(arr));
    }
    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}



