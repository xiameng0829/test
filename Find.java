package Test;
/*
//查找数组中指定元素（顺序查找）
public class Find{
    public static void main(String[] args){
        int[] arr={1,2,3,4,5};
        System.out.println(search(arr,4));
    }
    public static int search(int[] arr,int tosearch){
        for (int i=0;i<arr.length;i++){
            if(arr[i] == tosearch){
                return i;
            }
        }
        return -1;
    }
}
*/


//查找数组中指定元素（二分查找）
public class Find{
    static int count=0;
    public static void main(String[] args){
        int[] arr=makeArray();
        int ret=search(arr,999);
        System.out.println("ret="+ret+ "  count="+count);
    }
    public static int[] makeArray(){
        int[] arr=new int[10000];
        for(int i=0;i<10000;i++){
            arr[i] = i;
        }
        return arr;
    }
    public static int search(int[] arr,int tosearch){
        int left=0;
        int right=arr.length-1;
        while (left<=right)
        {
            count++;
            int mid=(left+right)/2;
            if(tosearch<arr[mid]){
                right=mid-1;
            }
            else if(tosearch>arr[mid]){
                left=mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}






