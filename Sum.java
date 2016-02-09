public class Sum {

    // pre: n > 0
    // post: returns 1 + 2 + ... + (n-1) + n
    
    // Explicit version
    public static int sum(int n) {
	return n*(n+1)/2;
    }

    // Iterative version: uses a loop
    public static int sumI(int n) {
	int ans = 0;
	for (int i = 1; i < n; i++) {
	    ans += i;
	}
	return ans;
    }

    // recursive version
    public static int sumR(int n) {
	if (n == 1) return 1;
	return n + sumR(n-1); 
    }

    public static void main(String[] args) {
	int N = Integer.parseInt(args[0]);
	System.out.println("Sum : " + sum(N));
	System.out.println("SumI : " + sumI(N));
	System.out.println("SumR : " + sumR(N));
    }
}
