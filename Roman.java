public class Roman extends Number implements Comparable<Roman>{

    private int _n;
    private String _numeral;

    // constructor
    public Roman(int n) {
	if (n <= 0 || n > 4000)
	    throw new ArithmeticException();
	_n = n;
	_numeral = toRoman(n);
    }
   
    public String toString() {
	return _numeral;
    }

    public static String toRoman(int n) {
	  if (n <= 0) return "";
	  if (n < 4) return "I" + toRoman(n-1);
	  if (n == 4) return "IV";
	  if (n < 9) return "V" + toRoman(n-5);
	  if (n == 9) return "IX";
	  if (n < 40) return "X" + toRoman(n-10);
	  if (n < 50) return "XL" + toRoman(n-40);
	  if (n < 90) return "L" + toRoman(n-50);
	  if (n < 100) return "XL" + toRoman(n-90);
	  if (n < 400) return "C" + toRoman(n-100);
	  if (n < 500) return "CD" + toRoman(n-400);
	  if (n < 900) return "D" + toRoman(n-500);
	  if (n < 1000) return "CM" + toRoman(n-900);
	  return "M" + toRoman(n-1000);
    }

    public boolean equals(Object rhs) {
	return (rhs instanceof Roman) && _n == ((Roman)rhs)._n;
    }

    public int compareTo(Roman rhs) {
	return _n - rhs._n;
    }

    // implementations of the abstract methods form the Number class
    public int intValue() {
	return _n;
    }

    public long longValue() {
	return _n;
    }

    public double doubleValue() {
	return _n;
    }

    public float floatValue() {
	return _n;
    }

    public static void main(String[] args) {
	int N = Integer.parseInt(args[0]);
	for (int i = 1; i < N; i++) {
	    Roman a = new Roman(i);
	   //System.out.println(i + " : " + a); 
	}
	Roman a = new Roman(10);
	//System.out.println(a.compareTo(a));
	//System.out.println(a.equals("X"));
	//System.out.println(a.compareTo(new Roman(15))); // a negative int
        //System.out.println(a.compareTo(new Roman(5)))); // a positive int 
    }

}
