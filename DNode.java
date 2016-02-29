public class DNode {

    private String _value;
    private DNode _previous, _next;
    
    // constructor
    public DNode(String value, DNode previous, DNode next) {
	_value = value;
	_previous = previous;
	_next = next;
    }

    // accessor methods
    public String getValue() {
	return _value;
    }

    public DNode getPrevious() {
	return _previous;
    }

    public DNode getNext() {
	return _next;
    }

    // modifier methods
    public String setValue(String newValue) {
	String ans = getValue();
	_value = newValue;
	return ans;
    }

    public DNode setPrevious(DNode newPrevious) {
	DNode ans = getPrevious();
	_previous = newPrevious;
	return ans;
    }

    public DNode setNext(DNode newNext) {
	DNode ans = getNext();
	_next = newNext;
	return ans;
    }

    public String toString() {
	return _value;
    }

    public static void main(String[] args) {
	DNode a = new DNode("Amy", null, null);
	DNode b = new DNode("Bill", null, null);
	b.setPrevious(a);
	a.setNext(b);
	DNode c = new DNode("Carol", null, null);
	c.setPrevious(b);
	b.setNext(c);
	DNode curr = a;
	while (curr != null) {
	    System.out.println(curr);
	    curr = curr.getNext();
	}

	curr = c;

	while (curr != null) {
	    System.out.println(curr);
	    curr = curr.getPrevious();
	}

	// swap the values (not the nodes) Amy and Carol
	String t = a.getValue();
	a.setValue(c.getValue());
	c.setValue(t);
    }

}
