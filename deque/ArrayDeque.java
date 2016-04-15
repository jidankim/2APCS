public class ArrayDeque<E> implements Deque<E> {

    private E[] _arrayDeq;
    private int _head, _tail, _capacity, _size;

    public final static int CAPACITY = 1000;

    public ArrayDeque(int capacity) {
	_arrayDeq = (E[]) new Object[capacity+1];
	_head = 0;
	_tail = 1;
	_capacity = capacity+1;
	_size = 0;
    }

    public ArrayDeque() {
	this(CAPACITY);
    }

    public int size() {
	return _size;
    }

    public boolean isEmpty() {
	return size() == 0;
    }

    public boolean isFull() {
	return size() + 1 >= _capacity;
	// return _head == _tail;
    }

    public int floorMod(int a, int b) {
	return a - b * (int)(Math.floor(1.0*a/b));
    }

    public E getFirst() throws EmptyDequeException {
	if (isEmpty()) 
	    throw new EmptyDequeException("empty deque.");
	return _arrayDeq[floorMod(_head+1, _capacity)];
    }

    public E getLast() throws EmptyDequeException {
	if (isEmpty())
	    throw new EmptyDequeException("empty deque.");
	return _arrayDeq[floorMod(_tail-1, _capacity)];
    }

    public void addFirst(E val) throws FullDequeException{
	if (isFull())
	    throw new FullDequeException("full deque.");
	_arrayDeq[_head] = val;
	_head = floorMod(_head-1, _capacity);
	_size++;
    }

    public void addLast(E val) throws FullDequeException {
	if (isFull())
	    throw new FullDequeException("full deque.");
	_arrayDeq[_tail] = val;
	_tail = floorMod(_tail+1, _capacity);
	_size++;
    }

    public E removeFirst() throws EmptyDequeException {
	E ans = getFirst();
	_arrayDeq[floorMod(_head+1, _capacity)] = null;
	_head = floorMod(_head+1, _capacity);
	_size--;
	return ans;
	/*
	  E ans = getFirst();
	  int newHead = floorMod(_head + 1, _capacity);
	  _arrayDeq[newHead] = null;
	  _head = newHead;
	  _size--;
	  return ans;
	 */
    }

    public E removeLast() throws EmptyDequeException {
	E ans = getLast();
	_arrayDeq[floorMod(_tail-1, _capacity)] = null;
	_tail = floorMod(_tail-1, _capacity);
	_size--;
	return ans;
    }

    public boolean offerFirst(E val) {
	if (isFull())
	    return false;
	return addFirst(val);
    }
    public boolean offerLast(E val) {
	if (isFull())
	    reutrn false;
	return addLast(val);
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
		int curr = floorMod(_head+2, _capacity);
		while (curr != _tail){
		    ans += ", " + _arrayDeq[curr];
		    curr = floorMod(curr+1, _capacity);
		}
	    }
	}
	ans += "]";
	return ans;
    }

    public static void main(String [] args){
	Deque<Integer> d = new ArrayDeque<Integer>(10);
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
