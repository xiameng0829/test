package Array;

public class ArrayStack<E> implements Stack<E> {
	private ArrayE<E> array;
	public ArrayStack(int capacity){
		array = new ArrayE<E>(capacity);
	}
	
	public ArrayStack(){
		array = new ArrayE<E>();
	}
	
	@Override
	public int getSize(){
		return array.getSize();
	}
	
	@Override
	public boolean isEmpty(){
		return array.isEmpty();
	}
	
	public int getCapicity(){
		return array.getCapacity();
	}
	@Override
	public void push(E e){
		array.addLast(e);
	}
	@Override
	public E pop(){
		return array.removeLast();
	}
	
	@Override
	public E peek(){
		return array.getLast();
	}
	
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append("Stack:");
		res.append('[');
		for(int i=0; i<array.getSize();i++){
			res.append(array.get(i));
			if(i!=array.getSize()-1)
				res.append(",");
		}
		res.append("] top");
		return res.toString();
	}
	
}
