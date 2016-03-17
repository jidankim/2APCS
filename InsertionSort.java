import java.util.ArrayList;

public class InsertionSort {
    
    private static ArrayList<String> a;
    private static DLinkedList d;

    public static void main(String[] args) {
	int N = Integer.parseInt(args[0]);
	a = new ArrayList<String>();
	System.out.println(a.size());
	randomize(N);
	d = new DLinkedList();
	for (int i = 0; i < a.size(); i++)
	    d.addLast(a.get(i));
	System.out.println("shuffled arrayList: " + a);
	System.out.println("Doubly linekd list: " + d);
	/*
	 for (int i = a.size() - 1; i >= 0; i--)
	 d.addFirst(a.get(i));
	 */
	sort();
    }

    public static void randomize(int n) {
	for (int i = 0; i < n; i++)
	    a.add("" + i);
	for (int i = 0; i < n; i++){
	    int r = i + (int)(Math.random() * (n - i));
	    a.set(i, a.set(r, a.get(i)));
	}
	System.out.println("Random: " + a);
    }
    /*
Here's a sample run: $java InsertionSort 10


shuffled arraylist: [5, 7, 0, 6, 3, 9, 4, 2, 8, 1]
Doubly linked list: [5, 7, 0, 6, 3, 9, 4, 2, 8, 1 ]
 pivot: 7
 end: 0
 insert after: 5
 sorting: [5, 7, 0, 6, 3, 9, 4, 2, 8, 1 ]
 pivot: 0
 end: 6
 find insertion point : 7
 find insertion point : 5
 insert after: null
 sorting: [0, 5, 7, 6, 3, 9, 4, 2, 8, 1 ]
 pivot: 6
 end: 3
 find insertion point : 7
 insert after: 5
 sorting: [0, 5, 6, 7, 3, 9, 4, 2, 8, 1 ]
 pivot: 3
 end: 9
 find insertion point : 7
 find insertion point : 6
 find insertion point : 5
 insert after: 0
 sorting: [0, 3, 5, 6, 7, 9, 4, 2, 8, 1 ]
 pivot: 9
 end: 4
 insert after: 7
 sorting: [0, 3, 5, 6, 7, 9, 4, 2, 8, 1 ]
 pivot: 4
 end: 2
 find insertion point : 9
 find insertion point : 7
 find insertion point : 6
 find insertion point : 5
 insert after: 3
 sorting: [0, 3, 4, 5, 6, 7, 9, 2, 8, 1 ]
 pivot: 2
 end: 8
 find insertion point : 9
 find insertion point : 7
 find insertion point : 6
 find insertion point : 5
 find insertion point : 4
 find insertion point : 3
 insert after: 0
 sorting: [0, 2, 3, 4, 5, 6, 7, 9, 8, 1 ]
 pivot: 8
 end: 1
 find insertion point : 9
 insert after: 7
 sorting: [0, 2, 3, 4, 5, 6, 7, 8, 9, 1 ]
 pivot: 1
 end: null
 find insertion point : 9
 find insertion point : 8
 find insertion point : 7
 find insertion point : 6
 find insertion point : 5
 find insertion point : 4
 find insertion point : 3
 find insertion point : 2
 insert after: 0
 sorting: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ]
Sorted DLinkedList: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ]
     */
    public static void sort() {
	int N = d.size();
	DNode pivot = d.getFirst().getNext();
	for (int i = 1; i < N; i++) {
	    DNode pivotNext = pivot.getNext();
	    DNode prev = pivot.getPrevious();
	    while (d.hasPrevious(prev) &&
		   pivot.getValue().compareTo(prev.getValue()) < 0) {
		prev = prev.getPrevious();
	    }
	    d.remove(pivot);
	    d.addafter(prev, pivot);
	    // pivot = pivot.getNext(); ** Mistake **
	    pivot = pivotNext;
	}
    }

    /*
      public static void sort() {
      DNode curr = L.getFirst().getNext();
      while (L.hasNext(curr)) {
      DNode prev = curr.getPrevious();
      DNode next = curr.getNext();
      while (L.hasPrevious(prev)) {
      if (prev.getValue().compareTo(curr.getValue()) > 0 {
      prev = prev.getPrevios();
      } else break;
      }
      L.remove(curr);
      L.addAfter(prev, curr);
      curr = next;
      }
      }
     */
    
    /* arraylist insertion sort v1
    public static void sort() {
	for (int i = 1; i < a.size(); i++) {
	    System.out.println("start pass: " + i + " " + a);
	    System.out.println("walk down " + a.get(i));
	    for (int j = i; j > 0; j--) {
		if (a.get(j).compareTo(a.get(j-1)) < 0) {
		    a.set(j-1, a.set(j, a.get(j-1)));
		    System.out.println(a);
		} else break;
	    }
	}
	System.out.println("Sorted: " + a);
    }
    */

    /* arraylist insertion sort v2
      publc static void insertionSortR() {
      for (int i = 0; i < a.size(); i++) {
      System.out.println("start pass: " + i + " " + a);
      walkR(i);
      }
      }

      public static void walkR(int i) {
      if (i <= 0) return;
      String a = a.get(i-1);
      String b = a.get(i);
      if (a.compareTo(b) > 0) {
      a.set(i-1, a.set(i, a.get(i-1)));
      System.out.println(a);
      walkR(i-1);
      }
      }
     */

}
