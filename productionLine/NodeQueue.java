public class NodeQueue<E> implements Queue<E> {

    private Node<E> _queueFront, _queueRear;
    private int _size;

    public NodeQueue() {
	_queueFront = _queueRear = null;
	_size = 0;
    }

    public int size() {
	return _size;
    }

    public boolean isEmpty() {
	return size() == 0;
    }

    // O(1)
    public void enqueue(E element) {
	Node<E> newRear = new Node<E>(element, null);
	if (isEmpty()) {
	    _queueFront = _queueRear = newRear;
	} else {
	    _queueRear.setNext(newRear);
	    _queueRear = newRear;
	}
	_size++;
    }

    // O(1)
    public E front() throws EmptyQueueException{
	if (isEmpty()) 
	    throw new EmptyQueueException("Queue is empty");
	return _queueFront.getValue();
    }

    // O(1)
    public E dequeue() throws EmptyQueueException{
	E ans = front();
	_queueFront = _queueFront.setNext(null);
	_size--;
	if (isEmpty()) _queueRear = null;
	return ans;
    }
 
    public String toString(){
	String ans = "[ ";
	if (size() > 0) {
	    ans += front();
	}
	if (size() > 1){
	    Node<E> current = _queueFront.getNext();
	    while (current != null){
		ans += ", " + current.getValue();
		current = current.getNext();
	    }
	}
	ans += "]";
	return ans;
    }

    public static void main(String[] args){
	NodeQueue<Integer> q = new NodeQueue<Integer>();
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
