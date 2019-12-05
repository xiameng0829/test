package packaging;

import java.util.Arrays;

/**
 * @program:class
 * @description：动态数组
 * @Author:xiameng
 * @create:2019-12-03 20:51
 **/
public class Myarray {
    private int[] num; //具体存储元素的数组
    private int size; //有效元素

    public Myarray(){
        num=new int[16];
    }
    public Myarray(int length){
        num =new int[length];
    }

    /**
     * 向动态数组中添加元素，默认向数组末尾添加
     * @param data
     */
    public void add(int data){
        if(size==num.length){
            grow(); //扩容
        }
        num[size]=data;
        size++;
    }

    /**
     * 向动态数组的任意位置插入元素
     * @param index 插入的目标索引
     * @param data
     */
    public void add(int index,int data){
        //判断index是否合法
        if(index<0 || index>size){
            //只要index>size都是非法的，因为数组无法取到数组长度的下标
            System.out.println("索引非法！");
            return;
        }
        //数组尾插
        else if(index==size){
            add(data);
        }
        else{
            //数组中间位置插入
            //判断内部数组是否满载
            if(size==num.length){
                //扩容
                grow();
            }
            //将index以及之后元素向后位移
            System.arraycopy(num,index,num,index+1,size-index);
            num[index]=data;
            size++;
        }
    }

    /**
     * 在数组中查找是否有指定data的元素，若有返回索引
     * @param data
     * @return 找到返回元素下标，否则返回-1
     */
    public int find(int data) {
        for (int i = 0; i <size ; i++) {
            if(num[i]==data){
                System.out.println("找到元素");
                return i;
            }
        }
        System.out.println("元素不存在");
        return -1;
    }

    /**
     * 在数组中查找是否有指定元素
     * @param data
     * @return
     */
    public boolean contains(int data) {
        for (int i = 0; i < size; i++) {
            if(num[i]==data){
                System.out.println("找到元素");
                return true;
            }
        }
        System.out.println("未找到元素");
         return false;
    }

    /**
     * 在数组中删除第一个出现的指定内容
     * @param data
     * @return
     */
    public boolean remove(int data){
        for (int i = 0; i <size ; i++) {
            if(num[i]==data){
                //此时i就是待删除的元素下标
                //{1,10,2,3,4,0}->{1,2,3,4,4,0}
                System.arraycopy(num,i+1,num,i,size-i-1);
                num[size]=0;
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * 取得指定位置的元素
     * @param index
     * @return
     */
    public int get(int index) {
        if(rangeCheck(index)){
            return num[index];
        }
        return -1;
    }

    /**
     * 修改指定索引的内容
     * @param index  指定的元素下标
     * @param data   修改后的内容
     * @return
     */
    public boolean set(int index,int data){
        if(rangeCheck(index)){
            num[index]=data;
            return true;
        }
        return false;
    }

    //返回动态数组长度
    public int size(){
        return size;
    }

    //打印动态数组长度
    public  void print(){
        //数组永远无法取到数组长度下标，因此不能等于size
        for (int i = 0; i <size ; i++) {
            System.out.print(num[i]+"、");
        }
        System.out.println();
    }

    //清空所有数组元素
    public void clear() {
        //将num中每个元素改为0
        Arrays.fill(num,0);
    }

    //内部数组扩容方法
    //此方法只有本类使用，因此将其封装
    private void grow(){
        num=Arrays.copyOf(num,num.length<<1);
    }

    //内部校验访问index是否合法方法
    private boolean rangeCheck(int index){
        if(index<0 || index>=size){
            System.out.println("索引非法！");
            return false;
        }
        return true;
    }
}
