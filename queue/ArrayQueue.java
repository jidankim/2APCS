public class ArrayQueue<E> implements Queue<E> {

    private E[] _queue;
    private int _size, _front, _rear;
    
    private final static int CAPACITY = 1000;

    public ArrayQueue(int capacity) {
	_queue = (E[]) new Object[capacity]; // compiler warning
	_size = 0;
	_front = 0;
	_rear = 0;
    }

    public ArrayQueue() {
	this(CAPACITY);
    }

    // O(1)
    public int size() {
	return _size;
    }
    
    // O(1)
    public boolean isEmpty() {
	return size() == 0;
    }

    // O(1)
    public void enqueue(E element) throws FullQueueException{
	if (size() == _queue.length)
	    throw new FullQueueException("Queue is full");
	// _queue[_rear++ % _queue.length] = element; wrong?
	_queue[_rear] = element;
	_rear = (_rear + 1) % _queue.length;
	_size++;
    }

    // O(1)
    public E front() throws EmptyQueueException{
	if (isEmpty())
	    throw new EmptyQueueException("Queue is empty");
	return _queue[_front];
    }

    // O(1)
    public E dequeue() throws EmptyQueueException{
	E ans = front();
	// _queue[_front++ % _queue.length] = null;
	_queue[_front] = null;
	_front = (_front + 1) % _queue.length;
	_size--;
	return ans;
    }

    // O(N)
    public String toString() {
	String ans = "[";
	if (size() > 0) ans += _queue[0];
	if (size() > 1) 
	    for (int i = (_front + 1)%_queue.length; i != _rear; i=(i+1)%_queue.length)
		ans += ", " + _queue[i];
	ans += "]";
	return ans;
    }

    public static void main(String[] args){
	Queue<Integer> q = new ArrayQueue<Integer>(10);
	System.out.println("Empty: " + q.isEmpty());
	System.out.println(q);
	for (int i = 0; i < 10; i++){
	    q.enqueue(i);
	    System.out.println("enqueue: " + i + " " + q);
	}
	System.out.println("front: " + q.front());
	while (!q.isEmpty()){
	    System.out.println("dequeue: " + q.dequeue() + " " + q);
	}

    }

}
