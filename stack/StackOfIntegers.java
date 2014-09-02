package stack;

public class StackOfIntegers {

	private int[] elements;
	private int size;
	
	public static final int DEFAULT_CAPACITY = 16;
	
	public StackOfIntegers() {
		this(DEFAULT_CAPACITY);
	}
	
	public StackOfIntegers(int capacity) {
		elements = new int[capacity];
	}
	
	public boolean empty() {
		return size == 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public int peek() {
		return elements[size - 1];
	}
	
	public int pop() {
		return elements[--size];
	}
	
	public int push(int n) {
		if(size >= elements.length - 1) {
			int[] newElements = new int[elements.length * 2];
			System.arraycopy(elements, 0, newElements, 0, elements.length);
//			for(int i = 0; i < size; i++)
//				newElements[i] = elements[i];
			elements = newElements;	
		}
		
		return elements[size++] = n;
	}
	
	public static void main(String[] args) {
		StackOfIntegers stack = new StackOfIntegers();
		
		for (int i = 0; i < 18; i++) {
			System.out.print(i + " ");
			stack.push(i);
		}
		
		System.out.println();
		while(!stack.empty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	
}
