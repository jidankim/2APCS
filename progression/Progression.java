// General numeric progression
// ex. 1 2 3 4 5 6 7
//     5 6 7 8 8 9 10

public class Progression{
    protected int _first, _curr;

    // constructor
    public Progression(int first){
	_first = first;
    }

    public Progression(){
	this(1);
    }

    // post: reset progression to first value and return first value
    public int firstValue(){
	_curr = _first;
	return _curr;
    }
    
    // post : advances progression to the next value and return it 
    public int nextValue(){
	return ++_curr;
    }

    // pre: n > 0
    // post: prints the first n values
    public void printProgression(int n){
	String ans = firstValue() + " ";
	for (int i = 1; i < n; i++)
	    ans += nextValue() + " ";
	System.out.println( ans);
    }


}
