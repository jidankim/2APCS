public class ArrayStack<E> implements Stack<E> {

    private E[] _stack;
    private int _capacity;
    private int _top; // refers to the index position of the top
    
    private final static int CAPACITY = 1000;

    public ArrayStack(int capacity) {
	_stack = (E[]) new Object[capacity];
	_capacity = capacity;
	_top = -1;
    }

    public int size() {
	return _top + 1;
    }
    
    public boolean isEmpty() {
	return size() == 0;
    }

    public void push(E element) throws FullStackException{
	if (size() == _capacity)
	    throw new FullStackException("Stack is full");
	_stack[++_top] = element;
    }

    public E top() throws EmptyStackException{
	if (isEmpty())
	    throw new EmptyStackException("Stack is empty");
	return _stack[_top];
    }

    public E pop() throws EmptyStackException{
	E ans = top();
	_stack[_top--] = null;
	return ans;
    }

}
