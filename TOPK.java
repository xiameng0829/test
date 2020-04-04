import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program:practice
 * @description：求前K个最小(最大)的数
 * @Author:xiameng
 * @create:2020-04-04 16:17
 **/
class TopKComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}
public class TOPK {
    public static Integer[] findKNum(Integer[] array,int k){
        TopKComparator topKComparator = new TopKComparator();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, topKComparator);
        for (int i = 0; i < array.length; i++) {
            if(minHeap.size() < k ){
                //将前k个元素放在堆里面
                minHeap.offer(array[i]);
            }else {
                Integer val = minHeap.peek();
                //堆顶元素和数组当中的元素进行比较
                //如果堆顶的小  堆顶元素先出堆  那么就把数组的元素放到堆当中
                if(val!=null && val > array[i]){
                    minHeap.poll();
                    minHeap.offer(array[i]);
                }
            }
        }

        Integer[] ret = new Integer[k];
        for (int i = 0; i < k; i++) {
            Integer num = minHeap.poll();
            ret[i] = num;
        }
        return ret;
    }

    public static void main(String[] args) {
        Integer[] array = {12,4,6,9,2,10,55,60};
        Integer[] ret = findKNum(array,5);
        System.out.println(Arrays.toString(ret));
    }
}
