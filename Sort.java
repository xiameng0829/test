import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * @program:practice
 * @description：排序
 * @Author:xiameng
 * @create:2020-03-28 17:32
 **/
public class Sort {
    /**
     * 时间复杂度： 最好：O(n)  最坏：O(n^2)
     * 空间复杂度： O(1)
     * 稳定性：稳定排序
     * 插入排序
     * @param array
     */
    public static void insertSort(int[] array,int left,int right) {
        for (int i = left+1; i <= right; i++) {
            int tmp=array[i];
            int j=0;
            for (j=i-1;j >=0; j--) {
                if(array[j]>=tmp){
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }



    public static void shell(int[] array,int gap) {
        for (int i = 1; i < array.length; i++) {
            int j=0;
            int tmp = array[i];
            for (j = i-gap; j >= 0; j=j-gap) {
                if(array[j]>tmp){
                    array[j+gap] = array[j];
                }else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    /**
     * 希尔排序
     * 时间复杂度： 最好：O(n)  最坏：O(n^2)
     * 空间复杂度： O(1)
     * 稳定性：不稳定排序
     * @param array
     */
    public static void shellSort(int[] array) {
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }

    /**
     * 选择排序：每次从待排序数字的后面，选取一个比当前数字小的数据进行交换，直到把当前的序列遍历完成
     * 时间复杂度：O(n^2)，不分好坏
     * 空间复杂度：O(1)
     * 稳定性：不稳定排序
     * @param array
     */
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i]>array[j]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    /**
     * 堆排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * 稳定性：不稳定排序
     * @param array
     */
    public static void createHeap(int[] array){
        for (int i = (array.length-1-1)/2; i >= 0 ; i--) {
            adjustDown(array,i,array.length);
        }
    }
    public static void adjustDown(int[] array,int root,int len){
        int parent = root;
        int child = 2*parent+1;
        //有左孩子
        while (child<len){
            //child+1 < len证明有右孩子，找到左右孩子最大值
            if(child+1 < len && array[child] < array[child+1]){
                child++;
            }
            //child保存的就是左右孩子的最大值
            if(array[child] >array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }
    public static void heapSort(int[] array){
        //创建大根堆
        createHeap(array);
        //堆顶元素和最后一个元素进行交换
        int end = array.length-1;
        while (end>0){
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown(array,0,end);
            end--;
        }
    }


    /**
     * 冒泡排序
     * 时间复杂度：O(n^2)
     * 优化flg之后时间复杂度为O(n)
     * 空间复杂度：O(1)
     *  稳定性：稳定排序
     * @param array
     */
    public static void bubbleSort(int[] array) {
        boolean flg = true;
        for (int i = 0; i < array.length-1; i++) {
            flg = false;
            for (int j = 0; j < array.length-1; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flg = true;
                }
            }
            if(flg == false){
                break;
            }
        }
    }





    /**
     * 快速排序（采用分治思想）
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     *  稳定性：不稳定排序
     * @param array
     */
    public static void quickSort(int[] array){
        //quick(array,0,array.length-1);
        quickNor(array,0,array.length-1);
    }
    public static void quick(int[] array,int left,int right){
        //递归结束条件
        if(left >= right){
            return;
        }
        //优化1：因为数据在每一次排序之后，都慢慢趋近于有序，那么此时可以用直接插入排序
        if(right-left+1<=100){
            insertSort(array,left,right);
            return;
        }

        //优化2：数据有序的情况下
        selectPivotMedianofThree(array,left,right);

        int pivot = partion(array,left,right);
        quick(array, left, pivot - 1);
        quick(array, pivot + 1, right);
    }

    //三数取中
    public static void selectPivotMedianofThree(int[] array,int left,int right){
        int mid = (right+left)/2;
        if (array[left]>array[right]){
            swap(array,left,right);
        }
        if (array[left]<array[mid]){
            swap(array,left,mid);
        }
        if (array[mid]>array[right]){
            swap(array,mid,right);
        }
        //array[mid] <= array[left] <= array[right]
    }
    public static void swap(int[] array,int left,int right){
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    //挖坑法
    public static int partion(int[] array,int left,int right) {
        int tmp = array[left];
        while (left < right){
            //在后面找到比tmp小的数据
            while (left<right && array[right]>=tmp){
                right--;
            }
            if(left>=right){
                break;
            }else {
                array[left] = array[right];
            }
            //在前面找到比tmp大的数据
            while (left<right && array[left]<=tmp){
                left++;
            }
            if(left>=right){
                break;
            }else {
                array[right] = array[left];
            }
        }
        //相遇之后
        array[left] = tmp;
        return left;
    }

    /**
     * 非递归快排
     * @param array
     * @param start
     * @param end
     */
    public static void quickNor(int[] array,int start,int end){
        Stack<Integer> stack = new Stack<>();
        int low = start;
        int high = end;
        int pivot = partion(array,start,end);
        if(pivot > low+1){
            stack.push(low);
            stack.push(pivot-1);
        }
        if(pivot < high-1){
            stack.push(pivot+1);
            stack.push(high);
        }
        while (!stack.empty()){
            high = stack.pop();
            low = stack.pop();
            pivot= partion(array,low,high);
            if(pivot > low+1){
                stack.push(low);
                stack.push(pivot-1);
            }
            if(pivot < high-1){
                stack.push(pivot+1);
                stack.push(high);
            }
        }
    }


    /**
     * 归并排序
     * 时间复杂度：O(n * log(n))
     * 空间复杂度：O(n)
     * 稳定排序
     * @param array
     */
    public static void mergeSort(int[] array){
        mergeSortInternal(array,0,array.length-1);
    }
    public static void mergeSortInternal(int[] array,int low,int high){
        if(low >= high)
            return;
        int mid = (low+high)/2;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid+1,high);
        //合并
        merge(array,low,mid,high);
    }
    public static void merge(int[] array,int low,int mid,int high){
        int s1 = low;
        int s2 = mid+1;
        int len = high - low + 1;
        int[] tmp = new int[len];//每次合并之后的数组大小
        int i = 0;//tmp的下标
        while (s1 <= mid && s2 <= high){
            if(array[s1] <= array[s2]){
                tmp[i++] = array[s1++];
            }else {
                tmp[i++] = array[s2++];
            }
        }
        while (s1 <= mid){
            tmp[i++] = array[s1++];
        }
        while (s2 <= high){
            tmp[i++] = array[s2++];
        }
        //把临时数组内的数据，拷贝到原有的数组中
        for (int j = 0; j < len; j++) {
            array[low+j] = tmp[j];
        }
    }

    /**
     * 非递归归并排序
     * @param array
     */
    public static void mergeSort1(int[] array){
        for (int gap = 1; gap < array.length; gap*=2) {
            merge1(array,gap);
        }
    }
    public static void merge1(int[] array,int gap){
        int[] tmp = new int[array.length];
        int k =0;
        int s1 = 0;
        int e1 = s1 + gap -1;
        int s2 = e1+1;
        int e2 = s2+gap-1 >=array.length ? array.length-1 : s2+gap-1;
        //判断是否有两个归并段
        while (s2 < array.length){
            while (s1 <= e1 && s2 <=e2){
                if(array[s1] <= array[s2]){
                    tmp[k++] = array[s1++];
                }else {
                    tmp[k++] = array[s2++];
                }
            }
            while (s1 <= e1){
                tmp[k++] = array[s1++];
            }
            while (s2 <= e2){
                tmp[k++] = array[s2++];
            }
            s1 = e2+1;
            e1 = s1+gap-1;
            s2 = e1+1;
            e2 = s2+gap-1 >=array.length ? array.length-1 : s2+gap-1;
        }
        //没有第二个归并段
        while (s1 <= array.length-1){
            tmp[k++] = array[s1++];
        }
        for (int i = 0; i < tmp.length; i++) {
            array[i] = tmp[i];
        }
    }




    public static void main1(String[] args) {
        int[] array = new int[10000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            //array[i] = random.nextInt(100_0000);
            array[i] = i;
        }
        long startTime  = System.currentTimeMillis();
        quickSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        System.out.println(Arrays.toString(array));
    }


    public static void main(String[] args) {
        int[] array = {12,4,6,9,2,10,55,60};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        //heapSort(array);
        //bubbleSort(array);
        //quickSort(array);
        mergeSort1(array);
        System.out.println(Arrays.toString(array));
    }

}
