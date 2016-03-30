public class NodeStack<E> implements Stack<E> {

    private Node<E> _stackHead;
    private int _size;

    public NodeStack() {
	_stackHead = null;
	_size = 0;
    }

    public int size() {
	return _size;
    }

    public boolean isEmpty() {
	return size() == 0;
    }

    // O(1)
    public void push(E element) {
	_stackHead = new Node<E>(element, _stackHead);
	_size++;
    }

    // O(1)
    public E top() throws EmptyStackException{
	if (isEmpty()) 
	    throw new EmptyStackException("Stack is empty");
	return _stackHead.getValue();
    }

    // O(1)
    public E pop() throws EmptyStackException{
	E ans = top();
	_stackHead = _stackHead.setNext(null);
	_size--;
	return ans;
    }

    public String toString() {
	String ans = "[";
	if (size() > 0) ans += _stackHead.getValue();
	if (size() > 1) {
	    for (int i = 1; i < size(); i++) {
		_stackHead = _stackHead.getNext();
		ans += ", " + _stackHead.getValue();
	    }
	}
	ans += "]";
	return ans;
    }
    
    public static void main(String[] args){
	NodeStack<Integer> s = new NodeStack<Integer>();
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
