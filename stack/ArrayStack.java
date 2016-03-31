public class ArrayStack<E> implements Stack<E> {

    private E[] _stack;
    private int _capacity;
    private int _top; // refers to the index position of the top
    
    private final static int CAPACITY = 1000;

    public ArrayStack(int capacity) {
	_stack = (E[]) new Object[capacity]; // compiler warning
	_capacity = capacity;
	_top = -1;
    }

    public ArrayStack() {
	this(CAPACITY);
    }

    // O(1)
    public int size() {
	return _top + 1;
    }
    
    // O(1)
    public boolean isEmpty() {
	return size() == 0;
    }

    // O(1)
    public void push(E element) throws FullStackException{
	if (size() == _capacity)
	    throw new FullStackException("Stack is full");
	_stack[++_top] = element;
    }

    // O(1)
    public E top() throws EmptyStackException{
	if (isEmpty())
	    throw new EmptyStackException("Stack is empty");
	return _stack[_top];
    }

    // O(1)
    public E pop() throws EmptyStackException{
	E ans = top();
	_stack[_top--] = null;
	return ans;
    }

    public void transferTo(ArrayStack<E> rhs) {
	while (!isEmpty() && rhs.size != rhs._capacity) {
	    rhs.push(pop());
	}
    }

    // O(N)
    public String toString() {
	String ans = "[";
	if (size() > 0) ans += _stack[0];
	if (size() > 1) 
	    for (int i = 1; i < size(); i++)
		ans += ", " + _stack[i];
	ans += "]";
	return ans;
    }

    public static void main(String[] args){
	ArrayStack<Integer> s = new ArrayStack<Integer>(10);
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
