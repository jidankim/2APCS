public class CircleList {

    private Node _cursor;
    private int _size;
   
    public CircleList() {
	_cursor = null;
	_size = 0;
    }

    public int size() {
	return _size;
    }

    public boolean isEmpty() {
	return _size == 0;
    }

    public Node getCursor() {
	return _cursor;
    }

    public void add(Node newNode) {
	if (isEmpty()) {
	    _cursor = newNode;
	    _cursor.setNext(_cursor);
	} else {
	    newNode.setNext(_cursor.getNext());
	    _cursor.setNext(newNode);
	}
	_size++;
    }

    public void advance() {
	_cursor = _cursor.getNext();
    }

    public Node remove() {
	if (isEmpty()) throw new IllegalStateException("empty list");
	Node ret = _cursor.getNext();
	if (size() == 1) _cursor = null; // ret is still cursor
	else _cursor.setNext(ret.getNext());
	ret.setNext(null);
	_size--;
	return ret;
    }

    public String toString() {
	String ans = "";
	Node t = _cursor;
	for (int i = 0; i < size(); i++) {
	    ans += t + ", ";
	    t = t.getNext();
	}
	int len = ans.length();
	if (len > 0) ans = ans.substring(0, len-2);
	return "[" + ans + "]";
    }
    /*
    public static void main(String[] args) {
	CircleList L = newCircleList();
	System.out.println(L);
	L.add(new Node("Abe", null));
	System.out.println(L);
	L.add(new Node("Betty", null));
	System.out.println(L);
	L.advance();
	L.add(new Node("Ada", null));
	System.out.println(L);
    }
    */
}
