package Array;

public class ArrayE<E> {
	private E[] data;
	private int size;
	//���캯�����������������capacity���� Array
	public ArrayE(int capacity){
		data =(E[]) new Object[capacity];
		size =0;
	}
	//�޲����Ĺ��캯����Ĭ�����������capacity=10
	public ArrayE(){
		this(10);
	}
	//��ȡ���������
	public int getCapacity(){
		return data.length;
	}
	//��ȡ��ֵ�е�Ԫ�ظ���
	public int getSize(){
		return size;
	}
	//���������Ƿ�Ϊ��
	public boolean isEmpty(){
		return size==0;
	}
	//��index������λ�ò���һ����Ԫ��e
	public void add(int index,E e){
		if(size==data.length){
			throw new IllegalArgumentException("A");
		}
		if(index<0||index>size){
			throw new IllegalArgumentException("A");
		}
		for(int i=size-1;i>=index;i--){
			data[i+1]=data[i];
		}
		data[index]=e;
		size ++;
	}
	//������Ԫ�غ����һ����Ԫ��
	public void addLast(E e){
		add(size,e);
	}
	//������Ԫ��ǰ���һ����Ԫ��
	public void addFirst(E e){
		add(0,e);
	}
	//��ȡindex����λ�õ�Ԫ��
	public E get(int index){
		if(index<0||index>=size){
			throw new IllegalArgumentException("Get failed. Index is illegal");
		}
		return data[index];
	}
	public E getLast(){
		return get(size-1);
	}
	public E getFirst(){
		return get(0);
	}
	//�޸�index����λ�õ�Ԫ��Ϊe
	public void set(int index,E e){
		if(index<0 || index>=size){
			throw new IllegalArgumentException("Set failed. Index is illegal");
		}
		data[index] = e;
	}
	//�����������Ƿ���Ԫ��e
	public boolean contains(E e){
		for(int i=0;i<size;i++){
			if (data[i].equals(e));
			return true;
		}
		return false;
	}
	//����������Ԫ��e���ڵ����������������Ԫ��e���򷵻�-1
	public int find(E e){
		for(int i=0;i<size;i++){
			if (data[i].equals(e));
			return i;
		}
		return -1;
	}
	//��������ɾ��indexλ�õ�Ԫ�أ�����ɾ����Ԫ��
	public E remove(int index){
		if(index<0||index>=size){
			throw new IllegalArgumentException("Remove failed");
		}
		E ret =data[index];
		for(int i=size+1;i<index;i++){
			data[i-1]=data[i];
		}
		size--;
		data[size]=null;
		return ret;
	}
	//��������ɾ����һ��Ԫ�أ�����ɾ����Ԫ��
	public E removeFirst(){
		return remove(0);
	}
	//��������ɾ�����һ��Ԫ�أ�����ɾ����Ԫ��
	public E removeLast(){
		return remove(size-1);
	}
	//��������ɾ��Ԫ��e
	public void removeElement(E e){
		int index =find(e);
		if(index!=-1)
		remove(index);
	}
	public String toString(){
		StringBuilder res=new StringBuilder();
		res.append(String.format("Array:size=%d,capacity=%d\n", size,data.length));
		res.append('[');
		for(int i=0;i<size;i++){
			res.append(data[i]);
			if(i!=size-1){
				res.append(",");
			}
		}
		res.append(']');
		return res.toString();
	}
	//������ռ���������newCapacity��С
	private void resize(int newCapacity){
		E[] newData = (E[])new Object[newCapacity];
		for(int i=0;i<size;i++)
			newData[i] =data[i];
		data = newData;
	}
}
