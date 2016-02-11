public class Permutation {

    public static void permutation(String str) {
	pH(str, "");
    }

    public static void pH(String str, String ans) {
	int L = str.length();
	if (L == 0) {
	    System.out.println(ans);
	} else {
	    for (int i = 0; i < L; i++) {
		String curr = str.substring(i, i+1);
		pH(str.replace(curr, ""), ans + curr);
	    }
	}
    }

    public static void main(String[] args) {
	permutation(args[0]);
    }
}
