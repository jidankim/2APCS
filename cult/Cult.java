/*Write a program that simulates M people sitting in a circle. Each person
is numberd from 1 to M. Then remove every kth person until there is only
1 person remaining in the list.

Your program should read M and k from the command line.
Use a CircleList to store the people.
Then print out the order of removals.


Below is are 3 sample runs:


$java cult 5 2

[5, 1, 2, 3, 4]
poisoned: 2
poisoned: 4
poisoned: 1
poisoned: 5
survivor: 3

$java cult 5 3
[5, 1, 2, 3, 4]
poisoned: 3
poisoned: 1
poisoned: 5
poisoned: 2
survivor: 4

$java cult 7 4
[7, 1, 2, 3, 4, 5, 6]
poisoned: 4
poisoned: 1
poisoned: 6
poisoned: 5
poisoned: 7
poisoned: 3
survivor: 2
*/

import java.util.ArrayList;

public class Cult {
    
    private static CircleList _circle;

    public static void randomize(int n) {
	ArrayList a = new ArrayList<String>();
	for (int i = 1; i <= n; i++)
	    a.add("" + i);
	for (int i = 0; i < n; i++) {
	    int r = i + (int)(Math.random() * (n - i));
	    a.set(i, a.set(r, "" + a.get(i)));
	}
	for (int i = 0; i < n; i++) {
	    _circle.add(new Node("" + a.get(i), null));
	    _circle.advance();
	}
    }
   
    public static void survive(int k) {
	while(_circle.size() > 1) {
	    for (int i = 0; i < k-1; i++) {
		_circle.advance();
	    }
	    System.out.println("poisoned: " + _circle.remove());
	    
	}
	System.out.println("survivor: " + _circle.remove());
    }

    public static void main(String[] args) {
	int M = Integer.parseInt(args[0]);
	int k = Integer.parseInt(args[1]);
	_circle = new CircleList();
	randomize(M);
	System.out.println(_circle);
	survive(k);
    }

}
