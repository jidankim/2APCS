import java.util.PriorityQueue;
import java.util.Comparator;

public class Demo {

    // O(NlogN) expected runtime
    // O(N) additional memory
    // uses a aux priority queue to sort the list in non decreasing order
    public static void pqsort(String[] list) {
	PriorityQueue<String> pq = new PriorityQueue<String>();
	for (String l : list) //O(N)
	    pq.add(l); //O(logN)
	for (int i = 0; i < list.length; i++)  //O(N)
	    list[i] = pq.poll(); //O(logN)
	
    }

    // O(log N)
    // pre: the list represents a heap with the minimum val at root (index 0)
    public static void add(ing v, ArrayList<Integer> heap) {
	heap.add(v); // adds to the end
	int pos = heap.size() - 1;
	while (pos > 0) {
	    int parentPos = (pos - 1) / 2;
	    if (heap.get(pos) >= heap.get(parentPos)) break;
	    heap.set(pos, heap.set(parentPos, v));
	    pos = parentPos;
	}
    }

    public static int minChildPos(int pos, ArrayList<Integer> heap) {
        int left = 2 * pos + 1;
	int right = left + 1;
	// no children
	if (left >= heap.size()) return -1;
	// only a left child
	if (right >= heap.size()) return left;
	// both children exist
	if (heap.get(left) <= heap.get(right)) return left;
	return right;
    }

    public static int removeMin(ArrayLIst<Integer> heap) {
	int N = heap.size();
	int ans = heap.get(0);
	int x = heap.remove(N-1);
	if (N > 0) {
	    heap.set(0,x);
	    int pos = 0;
	    int mcPos = minChildPos(pos, heap);
	    while (mcPos != -1) {
		if (heap.get(pos) <= heap.get(mcPos)) break;
		heap.set(pos, heap.set(mcPos, heap.get(pos)));
		pos = mcPos;
		mcPOs = minChildPos(pos, heap);
	    }
	}
	return ans;
    }

    public static void main(String [] args){
	String [] fruits = {"apple","banana","watermelon", "pear", "grapes", "cantalope", "orange", "kiwi"};

	PriorityQueue<String> pq = new PriorityQueue<String>();

	Comparator<String> comp = new ReverseComparator<String>();
	PriorityQueue<String> pq2 = new PriorityQueue<String>(comp);
	
	System.out.println("***** adding *****");
	for (String fruit: fruits){
	    pq.add(fruit);
	    pq2.add(fruit);
	    System.out.println("add: " + fruit);
	    System.out.println("\tmin pq: " + pq);
	    System.out.println("\tmax pq: " + pq2);
	}

	
	System.out.println("***** removing *****");	
	while(pq2.size() != 0){
	    System.out.print("remove min: " + pq.poll());
	    System.out.println("\t min pq : " + pq);
	    System.out.print("remove max: " + pq2.poll());
	    System.out.println("\t max pq : " + pq2);
	}
    }

}
