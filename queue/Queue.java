public interface Stack<E> {

    // inserts element e at the rear of the queue
    public void enqueue(E element);

    // removes and returns the element at the front of the queue
    public E dequeue() throws EmptyQueueException;
   
    // returns the element at the front of the queue
    public E front() throws EmptyQueueException;
   
    // returns the size of the queue
    public int size();
    
    // returns true if the queue is empty, false otherwise
    public boolean isEmpty();

}
