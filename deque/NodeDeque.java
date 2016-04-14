public class NodeDeque<E> implements Deque<E> {

    private DNode<E> _head, _tail;
    private int _size;

    // uses two dummy (sentinel) nodes
    public NodeDeque() {
	_head = new DNode(null, null, null);
	_tail = new DNode(null, _head, null);
	_head.setNext(_tail);
	_size = 0;
    }

    public E getFirst() throws EmptyDequeException {
	if (isEmpty())
	    throw new EmptyDequeException("empty deque.");
	return _head.getNext().getValue();
    }

    public E getLast() throws EmptyDequeException {
	if (isEmpty())
	    throw new EmptyDequeException("empty deque.");
	return _tail.getPrevious.getValue();
    }

    public void addFirst(E val) {
	/*
	DNode<E> oldFirst = _head.getNext();
	DNode<E> newFirst = new DNode(val, _head, oldFirst);
	_head.setNext(newFirst);
	oldFirst.setPrevious(newFirst);
	*/
	DNode<E> n = new DNode<E>(val, _head, _head.getNext());
	n.getNext().setPrevious(n);
	_head.setNext(n);
	_size++;
    }

    public void addLast(E val) {
	DNode<E> n = new DNode<E>(val, _tail.getPrevious(), _tail);
	n.getPrevious.setNext(n);
	_tail.setPrevious(n);
	_size++;
    }

    public E removeFirst() throws EmptyDequeException {
	/*
	E ans = getFirst();
	DNode<E> oldFirst = _head.getNext();
	DNode<E> newFirst = oldFirst.getNext();
	_head.setNext(newFirst);
	newFirst.setPrevious(_head);
	oldFirst.setNext(null);
	oldFirst.setPrevious(null);
	_size--;
	return ans;
	*/
	if (isEmpty())
	    throw new EmtpyDequeException("empty deque.");
	DNode<E> temp = _head.getNext();
	_head.setNext(temp.getNext());
	temp.getNext().setPrevious(_head);
	temp.setPrevious(null);
	temp.setNext(null);
	_size--;
	return temp.getValue();
    }

    public E removeLast() throws EmptyDequeException {
	if (isEmpty())
	    throw new EmtpyDequeException("empty deque.");
	DNode<E> temp = _tail.getPrevious();
	_tail.setPrevious(temp.getPrevious());
	temp.getPrevious().setNext(_tail);
	temp.setPrevious(null);
	temp.setNext(null);
	return temp.getValue();
    }

    public boolean offerFirst(E val) {
	addFirst(val);
	return true;
    }
    public boolean offerLast(E val) {
	addLast(val);
	return true;
    }

    public E pollFirst() {
	if (isEmpty()) return null;
	return removeFirst();
    }
    public E pollLast() {
	if (isEmpty()) return null;
	return removeLast();
    }

    public E peekFirst() {
	if (isEmpty()) return null;
	return getFirst();
    }
    public E peekLast() {
	if (isEmpty()) return null;
	return getLast();
    }

    public int size() {
	return _size;
    }

    public boolean isEmpty() {
	return size() == 0;
    }

    public String toString(){
	String ans = "[";
	if (size() > 0){
	    ans += getFirst() + "";
	    if (size() > 1){
		DNode<E> curr = _head.getNext().getNext();
		while (curr != _tail){
		    ans += ", " + curr.getValue();
		    curr = curr.getNext();
		}
	    }
	}
	ans += "]";
	return ans;
    }

    public static void main(String [] args){
	Deque<Integer> d = new NodeDeque<Integer>();
	System.out.println(d);
	for (int i = 0;i < 10; i++){
	    double r = Math.random();
	    if (r < 0.5){
		System.out.println("add first: " + i );
		d.offerFirst(i);
	    }
	    else{
		System.out.println("add last: " + i );
		d.offerLast(i);
	    }
	    System.out.println(d);
	}

	while(!d.isEmpty()){
	    double r = Math.random();
	    if (r < 0.5)
		System.out.println("pollFirst: " + d.pollFirst());
	    else
		System.out.println("pollLast: " + d.pollLast());
	    System.out.println(d);
	}


    }
}
