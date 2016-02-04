public class Roman {

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
	/*
	if (n <= 0) return "";
	else if (n == 5) return "V";
	else if (n == 10) return "X";
	else if (n == 50) return "L";
	else if (n % 5 == 4) return toRoman(n-4) + "IV";
	else if (n % 50 == 40) return toRoman(n-40) + "XL"; 
	else return toRoman(n-1) + "I";
	*/
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

    public static void main(String[] args) {
	int N = Integer.parseInt(args[0]);
	Roman r = new Roman(N);
	System.out.println(r);
    }

}
