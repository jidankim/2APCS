public class SLinkedList {
    
    private Node _head, _tail;
    private int _size;
    
    public SLinkedList() {
	_head = _tail = null;
	_size = 0;
    }

    // O(1)
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

    // O(1)
    public void addLast(String value) {
	Node newLast = new Node(value, null);
	if (_size == 0) _head = _tail = newLast;
	else {
	    _tail.setNext(newLast);
	    _tail = newLast;
	}
	_size++;
    }

    // O(1)
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

    // O(1)
    // post: throws and IllegalStateException if the list is empty
    //       otherwise returns the first value.
    public String getFirst() {
	if (_size == 0) throw new IllegalStateException();
	return _head.getValue();
    }

    // post: throws and IllegalStateException if the list is empty
    //       otherwise returns the last value.
    public String getLast() {
	if (_size == 0) throw new IllegalStateException();
	return _tail.getValue();
    }

    // O(N)
    // post: throw an exception if i < 0 or i >= size.
    //       if L = [a,b,c,d]
    //       L.get(0) returns a
    //       L.get(1) returns b
    public String get(int i) {
	if (i < 0 || i >= _size) throw new IllegalStateException();
	Node curr = _head;
	for (int k = 0; k < i; k++)
	    curr = curr.getNext();
	return curr.getValue();
    }

    // O(n)
    // S = [ a,b]
    // M = [ c,d,e]
    // S.append(M) -> [a,b,c,d,e]
    // M.append(S) -> [c,d,e,a,b]
    // Neither S nor M should be modified (no side effects).
    public SLinkedList append(SLinkedList L) {
	SLinkedList ret = new SLinkedList();
	for (int i = 0; i < size(); i++)
	    ret.addLast(get(i));
	for (int j = 0; j < L.size(); j++)
	    ret.addLast(L.get(j));
	return ret;
	/*
	  SLinkedList ret = new SLinkedList();
	  Node curr = this._head();
	  for (int i = 0; i < size(); i++) {
	      ret.addLast(curr.getValue()); //O(1)
	      curr = curr.getNext();
	  }
	  current = L._head;
	  for (int j = 0; j < size(); j++) {
	      ret.addLast(curr.getValue()); //O(1)
	      curr = curr.getNext();
	  }
	  return ret;
	 */
    }

    // L = [ c,a,t]
    // After L.reverse() (recursive), L becomes [ t,a,c].
    public void reverse() {
	if (_size != 1) {
	    String t = removeLast();
	    reverse();
	    addFirst(t);
        }
    }

    /*
      O(n)
      public void reverse() {
          reverseNode(_head, _head.getNext());
	  Node temp = _head;
	  _head = _tail;
	  _tail = temp;
      }
      
      private void reverseNode(Node a, Node b) {
          if (b == null) return;
	  if (a == head) a.setNext(null);
	  Node bNext = b.getNext();
	  b.setNext(a);
	  reverseNode(b, bNext);
      }

      O(n)
      public void reverse() {
          if (size() > 1) {
	      Node node = _head;
	      _head = _head.getNext();
	      _size--;
	      reverse();
	      _tail.setNext(node);
	      _tail = node;
	      _tail.setNext(null);
	      _size++;
	  }
      }
     */

    // O(n)
    // post: returns null if key is not in the list.
    //       otherwise Node that contains the first occurence of key in the list
    public Node search(String key) {
	Node ret = null;
	Node curr = _head;
	for (int i = 0; i < size(); i++) {
	    if (curr.getValue().equals(key)) {
		ret = curr;
		break;
	    }
	    curr = curr.getNext();
	}
	return ret;

	/* better
	  Node curr = _head;
	  while (curr != null) {
	      if (curr.getValue().equals(key))
	          return curr;
	      curr = curr.getNext();
	  }
	 */
    }

    // pre: x and y refers to Nodes in the list
    // post: swaps the Nodes (not just the values)
    public void swap(Node x, Node y) {
	
    }

    public int size() {
	return _size;
    }

    // O(n)
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
	//L.removeFirst();
	//System.out.println(L);
	L.reverse();
	System.out.println(L); // Bill Mary Sue
    }

}
