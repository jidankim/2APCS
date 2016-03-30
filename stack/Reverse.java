import java.util.List;
import java.util.ArrayList;

public class Reverse {

    // generic method
    public static<E> void reverse(List<E> L) {
	Stack<E> stack = new NodeStack<E>();
	// Stack<E> stack = new ArrayStack<E>(L.size());
	for (int i = 0; i < L.size(); i++)
	    stack.push(L.get(i)); // O(1) for an ArrayList
	                          // O(N) for a Linked List
	/*
	  for (E val : L)
	  stack.push(val);
	 */
	int counter = 0;
	while(!stack.isEmpty()) {
	    L.set(counter, stack.pop()); // O(1) for an ArrayList
	                                 // O(N) for a LinkedList
	    counter++;
	}
    }

    // post : returns true if the value is in the stack
    //        the order of stack should remain the same after the function
    public static<E> boolean inStack(Stack<E> stack, E value) {
	Stack<E> aux = new NodeStack<E>();
	boolean ans = false;
	while (!stack.isEmpty()) {
	    if (value.equals(stack.top())) {
		ans = true;
		break;
	    }
	    aux.push(stack.pop());
	}
	while (!aux.isEmpty()) {
	    stack.push(aux.pop());
	}
	return ans;
    }

    public static void main(String[] args) {
	ArrayList<Integer> L = new ArrayList<Integer>();
	for (int i = 0; i < 10; i++) 
	    L.add(i);
	System.out.println(L);
	reverse(L);
	System.out.println(L);

	ArrayList<String> L2 = new ArrayList<String>();
	String letters = "abcdefg";
	for (int i = 0; i < letters.length(); i++)
	    L2.add(letters.substring(i, i+1));
	System.out.println(L2);
	reverse(L2);
	System.out.println(L2);
	
    }

}
