public class Node<E> {
    
    private E _value;
    private Node<E> _next;

    public Node(E value, Node next) {
	_value = value;
	_next = next;
    }

    // accessor methods
    public E getValue() {
	return _value;
    }

    public Node<E> getNext() {
	return _next;
    }

    // modifier methods
    public E setValue(E str) {
	E ans = getValue();
	_value = str;
	return ans;
    }

    public Node<E> setNext(Node t) {
	Node<E> ans = getNext();
	_next = t;
	return ans;
    }

    //    public static void main(String[] args) {
	//	Node a = new Node("Sue", new Node("Mary", new Node("Bill", null)));
	//	System.out.println(a);
	//	System.out.println(a.getNext());
	//	System.out.println(a.getNext().getNext());
	//	System.out.println(a.getNext().getNext().getNext());
    //    }

					

}
