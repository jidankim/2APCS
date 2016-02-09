import java.util.ArrayList;

public class RomanApp {

    // pre: size > 0, lower, upper
    // post: returns a list with size elements,
    // each element is a random roman object whose value is in [lower, upper)
    public static ArrayList<Roman> populate(int size, int lower, int upper) {
	ArrayList<Roman> a = new ArrayList<Roman>();
	int range = upper - lower;
	for (int i = 0; i < size; i++) {
	    Roman r = new Roman((int)(Math.random() * range) + lower);
	    a.add(r);
	}
	return a;
    }

    // pre: L.size() > 0
    // post: returns the minimum value
    public static Roman min(ArrayList<Roman> L) {
	Roman ret = L.get(0);
	for (Roman curr : L) {
	    if (ret.compareTo(curr) > 0)
		ret = curr;
	}
	return ret;
    }

    public static Roman sum(ArrayList<Roman> L) {
	int ans = 0;
	for (Roman curr : L)
	    ans += curr.intValue();
	return new Roman(ans);
    }

    // pre: L.size() > 0
    // post: L is unchanged, returns the even Roman numbers
    public static ArrayList<Roman> filterEvens(ArrayList<Roman> L) {
	ArrayList<Roman> ret = new ArrayList<Roman>();
	for (Roman curr : L) 
	    if (curr.intValue() % 2 == 0)
		ret.add(curr);
	return ret;
    }

    // pre: L.size() > 0
    // post: n is added to each roman numeral in L
    // if L -> [I,II] mapAdd(1,L)
    // L becomes [II,III]
    public static void mapAdd(int n, ArrayList<Roman> L) {
	/* wrong example
	for (Roman curr : L) 
	    curr = new Roman(curr.intValue() + n);
	*/
	int i = 0;
	for (Roman curr : L) {
	    L.set(i, new Roman(curr.intValue() + n));
	    i++;
	}
	
    }

    public static void main(String[] args) {
	ArrayList<Roman> romans = populate(5, 2, 100);
	System.out.println(romans);
	Number minValue = min(romans);
	System.out.println("min: " + minValue + " int: " + minValue.intValue());
	Number total = sum(romans);
	System.out.println("sum: " + total + " int: " + total.intValue());
	System.out.println("filter evens: " + filterEvens(romans));
	mapAdd(2, romans);
	System.out.println(romans);
	
    }
}
