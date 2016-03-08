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

    public static void main(String[] args) {
	CircleList L = newCircleList();
	L.add(new Node("Abe", null));
	L.add(new Node("Betty", null));
    }
}
