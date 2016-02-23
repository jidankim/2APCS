public class SLinkedList {
    
    private Node _head, _tail;
    private int _size;
    
    public SLinkedList() {
	_head = _tail = null;
	_size = 0;
    }

    public void addFirst(String value) {
	/*
	if (_size == 0)
	    _tail = new Node(value, null);
	_head = new Node(value, _head);
	_size++;
	*/
	_head = new Node(value, _head);
	if (_size == 0) _tail = _head;
	_size++;
    }

    public void addLast(String value) {
	Node newLast = new Node(value, null);
	if (_size == 0) _head = _tail = newLast;
	else {
	    _tail.setNext(newLast);
	    _tail = newLast;
	}
	_size++;
    }

    public String removeFirst() {
	if (_size == 0) throw new IllegalStateException();
	String ans = _head.getValue();
	if (_size == 1) _tail = null;
        _head = _head.getNext();
	_size--;
	return ans;
    }

    public String removeLast() {
	String ans = _tail.getValue();
	if (_size <= 1) { 
	    removeFirst();
	} else {
	    Node n = _head;
	    while (n.getNext() != _tail) n = n.getNext();
	    n.setNext(null);
	    _tail = n;
	    _size--;
	}
	return ans;
    }

    public int size() {
	return _size;
    }

    public String toString() {
	String ans = "";
	Node n = _head;
	while (n != null) {
	    ans += n.getValue() + " ";
	    n = n.getNext();
	}
	return ans;
    }

    public static void main(String[] args) {
	SLinkedList L = new SLinkedList();
	System.out.println(L); // " "
	L.addFirst("Bill");
	System.out.println(L); // Bill
	L.addFirst("Mary");
	System.out.println(L); // Mary Bill
	L.addFirst("Sue");
	System.out.println(L); // Sue Mary Bill
	L.removeFirst();
	System.out.println(L);
    }

}
