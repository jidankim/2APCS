import java.util.PriorityQueue;

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

    public static int removeMin(ArrayList<Integer> heap) {
	int N = heap.size() - 1;
	int ret = heap.set(0, heap.remove(N));
        int pos = 0;
	while (pos < N) {
	    int child1 = pos * 2;
	    int child2 = pos * 2 + 1;
	    if (child1 >= N || child2 >= N || 
		heap.get(pos) > heap.get(child1) || 
		heap.get(pos) > heap.get(child2)) break;
	    if (heap.get(child1) > heap.get(child2)) {
		heap.set(child2, heap.set(pos, heap.get(child2)));
		pos = child2;
	    } else {
		heap.set(child1, heap.set(pos, heap.get(child1)));
		pos = child1;
	    }
	}
	return ret;
    }

    public static void main(String[] args) {
	
    }

}
