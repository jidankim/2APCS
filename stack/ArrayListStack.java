import java.util.ArrayList;

public class ArrayListStack<E> implements Stack<E> {

    private ArrayList<E> _stack;
    private int _top;
    
    public ArrayListStack() {
	_stack = new ArrayList<E>();
	_top = -1;
    }

    public int size() {
	return _top + 1;
    }

    public boolean isEmpty() {
	return size() == 0;
    }

    // O(1)
    public void push(E element) {
	_stack.add(element);
	_top++;
    }

    // O(1)
    public E top() throws EmptyStackException {
	if (isEmpty())
	    throw new EmptyStackException("Stack is empty");
	return _stack.get(_top);
    }
   
    // O(1)
    public E pop() throws EmptyStackException {
	E ans = top();
	_stack.remove(_top--);
	return ans;
    }

    public String toString() {
	return _stack.toString();
    }

    public static void main(String[] args){
	Stack<Integer> s = new ArrayListStack<Integer>();
	System.out.println("Empty: " + s.isEmpty());
	System.out.println(s);
	for (int i = 0; i < 10; i++){
	    s.push(i);
	    System.out.println("push: " + i + " " + s);
	}
	System.out.println("top: " + s.top());
	while (!s.isEmpty()){
	    System.out.println("pop: " + s.pop() + " " + s);
	}

    }
}
