package Try;

import org.omg.CORBA.UserException;

/**
 * @program:class
 * @description：异常
 * @Author:xiameng
 * @create:2020-03-03 20:07
 **/
public class Try {
    public static void main(String[] args) {
        try {
            int ret = func(10,0);
            System.out.println(ret);
        }catch (ArithmeticException e){
            System.out.println("ArithmeticException");
        }
        System.out.println("after");
    }
    public static int func(int a,int b) throws ArithmeticException{
        if(b==0){
            throw new ArithmeticException(); //手动抛出异常
        }
        return a/b;
    }

    /*
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        try {
            arr = null;
            System.out.println(arr[100]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("数组下标越界异常");
            e.printStackTrace();
        }catch (NullPointerException e){
            System.out.println("空指针异常");
            e.printStackTrace();
        }finally {
            System.out.println("code");
        }
    }
    */

    /*
    public static void main1(String[] args) {
        System.out.println(div(10,5));
    }
    public static int div(int a,int b){
        try {
            int ret = a/b;
            return ret;
        }catch (ArithmeticException e){
            e.printStackTrace();
            return 88;
        }finally {
            return 100;
        }
    }
    */
}
