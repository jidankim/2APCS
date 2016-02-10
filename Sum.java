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
	for (int i = 1; i < n+1; i++) {
	    ans += i;
	}
	return ans;
    }

    // recursive version
    public static int sumR(int n) {
	if (n == 1) return 1;
	return n + sumR(n-1); 
    }

    // task 2
    // ex. sum(2,3,5) = 2 + 5 + 8 + 11 + 14 = 40
   
    // pre: a,d,n are positive integers
    // post: a + (a + d) + (a + 2d) + ... + (a + (n-1)d)

    // explicit
    public static int sum(int a, int d, int n) {
	return (2*a + (n-1)*d) * n / 2;
    }

    public static int sumI(int a, int d, int n) {
	int sum = 0;
	for (int i = 0; i < n; i++) {
	    sum += a + i*d;
	}
	return sum;
    }

    public static int sumR(int a, int d, int n) {
	if (n == 1) return a;
	return a + sumR(a+d, d, n-1);
    }

    public static void main(String[] args) {
	int N = Integer.parseInt(args[0]);
	System.out.println("Sum : " + sum(N));
	System.out.println("SumI : " + sumI(N));
	System.out.println("SumR : " + sumR(N));
	System.out.println("sum : " + sum(2,3,N));
	System.out.println("sumI : " + sumI(2,3,N));
	System.out.println("sumR : " + sumR(2,3,N));
    }
}
