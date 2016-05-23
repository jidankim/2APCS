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

    public static void main(String[] args) {
	
    }

}
