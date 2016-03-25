public class GEDNode {

    private GameEntry _value;
    private GEDNode _previous, _next;
    
    // constructor
    public GEDNode(GameEntry value, GEDNode previous, GEDNode next) {
	_value = value;
	_previous = previous;
	_next = next;
    }

    // accessor methods
    public GameEntry getValue() {
	return _value;
    }

    public GEDNode getPrevious() {
	return _previous;
    }

    public GEDNode getNext() {
	return _next;
    }

    // modifier methods
    public GameEntry setValue(GameEntry newValue) {
	GameEntry ans = getValue();
	_value = newValue;
	return ans;
    }

    public GEDNode setPrevious(GEDNode newPrevious) {
	GEDNode ans = getPrevious();
	_previous = newPrevious;
	return ans;
    }

    public GEDNode setNext(GEDNode newNext) {
	GEDNode ans = getNext();
	_next = newNext;
	return ans;
    }

    public String toString() {
	return _value.toString();
    }
/*
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
    */

}
