public class DCircleList {

    private GEDNode _cursor;
    private int _size;
   
    public DCircleList() {
	_cursor = null;
	_size = 0;
    }

    public int size() {
	return _size;
    }

    public boolean isEmpty() {
	return _size == 0;
    }

    public GEDNode getCursor() {
	return _cursor;
    }

    public void add(GEDNode newNode) {
	if (isEmpty()) {
	    _cursor = newNode;
	    _cursor.setNext(_cursor);
            _cursor.setPrevious(_cursor);
	} else {
	    newNode.setNext(_cursor.getNext());
	    _cursor.getNext().setPrevious(newNode);
            _cursor.setNext(newNode);
            newNode.setPrevious(_cursor);
	}
	_size++;
    }

    public void advance() {
	_cursor = _cursor.getNext();
    }

    public GEDNode remove() {
	if (isEmpty()) throw new IllegalStateException("empty list");
	GEDNode ret = _cursor.getNext();
	if (size() == 1) _cursor = null; // ret is still cursor
	else {
            _cursor.setNext(ret.getNext());
            ret.getNext().setPrevious(_cursor);
        }
        ret.setNext(null);
        ret.setPrevious(null);
	_size--;
	return ret;
    }

    public String toString() {
	String ans = "";
	GEDNode t = _cursor;
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
