public class ArrayDeque<E> implements Deque<E> {

    private E[] _arrayDeq;
    private int _head, _tail, _capacity;

    public ArrayDeque(int capacity) {
	_arrayDeq = (E[]) new Object[capacity+1];
	_head = 0;
	_tail = 1;
	_capacity = capacity;
    }

    public int size() {
	return _arrayDeq.length;
    }

    public boolean isEmpty() {
	return size() == 0;
    }

    public int floorMod(int a, int b) {
	return a - b * (int)(Math.floor(1.0*a/b));
    }

    public E getFirst() throws EmptyDequeException {
	if (isEmpty()) 
	    throw new EmptyDequeException("empty deque.");
	return _arrayDeq[floorMod(_head+1, size())];
    }

    public E getLast() throws EmptyDequeException {
	if (isEmpty())
	    throw new EmptyDequeException("empty deque.");
	return _arrayDeq[floorMod(_tail-1, size())];
    }

    public void addFirst(E val) {
	_arrayDeq[_head] = val;
	_head = floorMod(_head-1, size());
    }

    public void addLast(E val) {
	_arrayDeq[_tail] = val;
	_tail = floorMod(_tail+1, size());
    }

    public E removeFirst() throws EmptyDequeException {
	E ans = getFirst();
	_arrayDeq[floorMod(_head+1, size())] = null;
	_head = floorMod(_head+1, size());
	return ans;
    }

    public E removeLast() throws EmptyDequeException {
	E ans = getLast();
	_arrayDeq[floorMod(_tail-1, size())] = null;
	_tail = floorMod(_tail-1, size());
	return ans;
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

    public String toString(){
	String ans = "[";
	if (size() > 0){
	    ans += getFirst() + "";
	    if (size() > 1){
		int curr = floorMod(_head+2, size());
		while (curr != _tail){
		    ans += ", " + _arrayDeq[curr];
		    curr = floorMod(curr+1, size());
		}
	    }
	}
	ans += "]";
	return ans;
    }

    public static void main(String [] args){
	Deque<Integer> d = new ArrayDeque<Integer>(1000);
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
