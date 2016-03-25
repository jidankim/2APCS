public class ScoresArray {
    
    private DCircleList _scores;

    // pre: n > 0, n represents the size of the array
    // post: there are n GameEntries stored.
    public ScoresArray(int n) {
	_scores = new DCircleList();
	for (int i = 0; i < n; i++) {
	    _scores.add(new GEDNode(new GameEntry(), null, null));
	    _scores.advance();
        }
    }

    public ScoresArray() {
	this(10);
    }

    public boolean add(GameEntry entry) {
        boolean ans = false;
        for (int i = 0; i < numScores(); i++) {
            GEDNode other = topEntry();
            if (entry.compareTo(other.getValue()) > 0) {
                GameEntry temp = other.getValue();
                other.setValue(entry);
                entry = temp;
                ans = true;
            }
            _scores.advance();
        }
        return ans;
    }

    public void initialize(int len, int maxScore) {
	for (int i = 0; i < numScores(); i++) {
	    GameEntry entry = GameEntry.randomEntry(len, maxScore);
	    if (add(entry))
		System.out.println("adding : " + entry);
	    else
		System.out.println(entry + " not added");
	}
    }

    public GEDNode topEntry() {
	return _scores.getCursor();
    }
    
    public int numScores() {
	return _scores.size();
    }

    public String toString() {
	String ans = "Rank\tInitials\tScore\n";
	for (int i = 0; i < numScores(); i++) {
            GEDNode curr = topEntry();
	    ans += (i+1) + ".\t" + curr + "\n";
            _scores.advance();
	}
	return ans;
    }

    public static void main(String[] args) {
	ScoresArray s = new ScoresArray(10);
	System.out.println(s);
	s.initialize(3, 2000);
	System.out.println(s);
        for (int i = 0; i < s.numScores(); i++) {
	    GameEntry a = GameEntry.randomEntry(3, 2000);	 
	    if (s.add(a))
		System.out.println("adding : " + a);
	    else
		System.out.println(a + " not added");
        }
	System.out.println(s);
    }

}
