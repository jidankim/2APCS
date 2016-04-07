public class StackQ<E> implements Stack<E> {

    private Queue<E> _main, _temp;

    public StackQ() {
	_main = new NodeQueue<E>();
	_temp = new NodeQueue<E>();
    }

    // pre: _main represents the stack, _temp is empty
    public E top() throws EmptyStackException{
	if (isEmpty()) throw new EmptyStackException("Empty Stack.");
	return _main.front();
    }

     // O(1)
    // pre: _main represents the stack, _temp is empty
    public E pop() throws EmptyStackException{
	E ans = top();
	return _main.dequeue();
    }

    public void push(E element) {
	_temp.enqueue(element);
	while (!_main.isEmpty()) {
	    _temp.enqueue(_main.dequeue());
	}
    }

    public int size() {
	return _main.size();
    }

    public boolean isEmpty() {
	return size() == 0;
    }

    public String toString() {
	String ans;
	if (_main.isEmpty()) ans = _temp.toString();
	else ans = _main.toString();
	return ans;
    }

    public static void main(String[] args) {
	Stack<Integer> s = new StackQ<Integer>();
	System.out.println(s);
	
	for (int i = 0; i < 10; i++) {
	    s.push(i);
	    System.out.println("push: " + i + " " + s);
	}
	System.out.println("top: " + s.top());
	while (!s.isEmpty()) {
	    if (Math.random() < 0.8)
		System.out.println("pop: " + s.pop() + " " + s);
	    else {
		int n = (int)(Math.random() * 100);
		s.push(n);
		System.out.println("push: " + n + " " + s);
	    }
	}
    }

}
