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

    public void push(E element) {
	_stackHead = new Node<E>(E, _stackHead);
	_size++;
    }

    public E top() {
	return _topNode.getValue();
    }

    public E pop() {
	E ans = top();
	
    }
    
}
