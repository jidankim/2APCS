public class Comma {

    // pre: n >= 0
    public static String withCommas(int n) {
	/* doesnt work completely
	if (n < 10) return "00" + n;
	else if (n < 100) return "0" + n;
	else if (n < 1000) return "" + n;
	else return withCommas(n/1000) + "," + withCommas(n%1000);
	*/

	String lastThere = n + "";
	if (n < 1000) return lastThere;
	lastThere = lastThere.substring(lastThere.length() - 3);
	return withCommas(n/1000) +  "," + lastThere;
    }

    public static void main(String[] args) {
	int N = Integer.parseInt(args[0]);
	System.out.println(withCommas(N));
    }

}
