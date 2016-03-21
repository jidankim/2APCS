public class ScoreArray {
    
    private GameEntry[] _scores;

    // pre: n > 0, n represents the size of the array
    // post: there are n GameEntries stored.
    public ScoreArray(int n) {
	_scores = new GameEntry[n];
	for (int i = 0; i < n; i++) {
	    _scores[i] = new GameEntry();
	}
    }

    public ScoreArray() {
	ScoreArray(10);
    }

    // O(n)
    // post: returns true if the entry is added.
    //       returns false otherwise
    //       if the entry is added, the entries 
    //       with a lower rank are shifted down
    public boolean add(GameEntry entry) {

    }

    public GameEntry topEntry() {
	return _scores[0];
    }
    
    public int numScores() {
	return _scores.length;
    }

    public String toString() {
	String ans = "Rank\tInitials\tScore";
	for (int i = 0; i < numScores(); i++) {
	    ans += (i+1) + ".\t" + _scores[i] + "\n";
	}
	return ans;
    }

    public static void main(String[] args) {
	ScoreArray s = new ScoreArray(5);
	System.out.println("scores: " + s.numScores());
	System.out.println("top entry: " + s.topEntry());
	System.out.println(s);
    }

}
