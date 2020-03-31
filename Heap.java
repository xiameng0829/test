import java.util.Arrays;

/**
 * @program:practice
 * @description
 * @Author:xiameng
 * @create:2020-03-28 15:08
 **/
public class Heap {
    public int[] elem;
    public int usedSize;

    public Heap() {
        this.elem = new int[10];
        this.usedSize = 0;
    }

    /**
     *
     * @param root  每棵子树根节点
     * @param len   每棵子树的结束位置
     */
    public void adjustDown(int root,int len){
        int parent = root;
        int child = 2*parent+1;
        //有左孩子
        while (child<len){
            //child+1 < len证明有右孩子，找到左右孩子最大值
            if(child+1 < len && this.elem[child] < this.elem[child+1]){
                child++;
            }
            //child保存的就是左右孩子的最大值
            if(this.elem[child] >this.elem[parent]){
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    /**
     * 创建二叉树
     * @param array
     */
    public void createHeap(int[] array){
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        //i是每棵子树根节点
        for (int i = (this.usedSize-1-1)/2; i >= 0 ; i--) {
            adjustDown(i,this.usedSize);
        }
    }

    /**
     * 插入
     * @param child
     */
    public void adjustUp(int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (this.elem[child] > this.elem[parent]) {
                int tmp = this.elem[parent];
                this.elem[parent] = this.elem[child];
                this.elem[child] = tmp;
                child = parent;
                parent = (child-1)/2;
            } else {
                break;
            }
        }
    }
    public void push(int val) {
        if (isFull()) {
            //扩容
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }

        this.elem[this.usedSize] = val;
        this.usedSize++;
        adjustUp(this.usedSize - 1);
    }
    private boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    /**
     * 堆的删除
     * 1. 将堆顶元素和堆中最后一个元素交换
     * 2. 将堆中有效数据个数减少一个
     * 3. 对堆顶元素进行向下调整
     */
    public void pop() {
        if(isEmpty()){
            throw  new RuntimeException("堆为空");
        }
        this.elem[0] = this.elem[this.usedSize-1];
        this.usedSize--;
        adjustDown(0,usedSize);
    }
    private boolean isEmpty(){
        return this.usedSize==0;
    }


    /**
     * 得到堆顶元素
     * @return
     */
    public int getTop(){
        if(isEmpty()){
            throw  new RuntimeException("堆为空");
        }
        return this.elem[0];
    }

    /**
     * 堆排序
     * 先将待排序序列建立为大根堆
     * 每次拿堆顶元素和最后一个待排序序列的数据进行交换，然后调整0号下标这棵树
     */
    public void heapSort(){
        int end = this.usedSize-1;
        while (end>0){
            int tmp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = tmp;
            adjustDown(0,end);
            end--;
        }
    }

    public void show(){
        for (int i = 0; i < usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] array={27,15,19,18,28,34,65,49,25,37};
        heap.createHeap(array);
        heap.show();
        System.out.println("===插入===");
        heap.push(80);
        heap.show();
        System.out.println("===删除===");
        heap.pop();
        heap.show();
        System.out.println(heap.getTop());
        System.out.println("===堆排序===");
        heap.heapSort();
        heap.show();
    }
}