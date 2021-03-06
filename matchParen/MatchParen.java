public class MatchParen{

    public final static String OPENING = "([{";
    public final static String CLOSING = ")]}";
    public final static String PARENTHESES = OPENING + CLOSING;


    
    //  *********** QUESTION 1 ************************************
    // returns true if exp2 is contained within exp1; false otherwise
    // e.g.  contains("mississippi","is") -> true
    //       contains("mississippi","Is") -> false
    //       contains("mississippi","ippi") -> true
    public static boolean contains(String exp1, String exp2){
        // < Your code goes here >
	return exp1.indexOf(exp2) != -1
    }


    //  *********** QUESTION 2 ************************************
    // post: removes all whitespace characters and non-parentheses
    //       from exp.
    public static String filterParen(String exp){
        // < Your code goes here >
	String ans = "";
	for (int i = 0; i < exp.length(); i++) {
	    String c = exp.substring(i, i+1);
	    if (conatains(PARENTHESES, c)) {
		ans += c;
	    }
	}
	return ans;
    }

    //  *********** QUESTION 3 ************************************
    // Uses a stack to check if exp has matching parentheses.
    // pre: is empty or only contains parentheses.
    public static boolean match(String exp){
        // < Your code goes here >	
	Stack<String> stack = new NodeStack<String>();
	if (exp.length() % 2 == 1) return false;
	while(exp.length() != 0) {
	    String token = exp.substring(0, 1);
	    if (contains(CLOSING, token)) {
		if (!stack.isEmpty() && OPENING.indexOf(token) == 
		    CLOSING.indexOf(stack.top())) {
		    stack.pop();
		} else return false;
	    } else stack.push(token);
	    exp = exp.substring(1);
	}
	return stack.isEmptpy();
    }

    // Assuming ()[]{} are the only characters
    public static void main(String [] args){
	String exp = "";

	System.out.print("> ");
	exp = StdIn.readLine();
	while ( !contains(exp,"-1")){
	    if (match(filterParen(exp)))
		System.out.println("Match");
	    else
		System.out.println("Don't match");
	    System.out.print("> ");
	    exp = StdIn.readLine();
	}
    }

}
