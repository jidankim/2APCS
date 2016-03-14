import java.util.ArrayList;

public class InsertionSort {
    
    private static ArrayList<String> a;

    public static void main(String[] args) {
	int N = Integer.parseInt(args[0]);
	a = new ArrayList<String>();
	System.out.println(a.size());
	randomize(N);
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

    public static void sort() {
	for (int i = 1; i < a.size(); i++) {
	    System.out.println("start pass: " + i + " " + a);
	    String move = a.get(i);
	    System.out.println("walk down " + move);
	    for (int j = i; j > 0; j--) {
		if (a.get(j).compareTo(a.get(j-1)) < 0) {
		    a.set(j-1, a.set(j, a.get(j-1)));
		    System.out.println(a);
		} else break;
	    }
	}
	System.out.println("Sorted: " + a);
    }

}
