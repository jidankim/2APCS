public class ScoresArray {
    
    private GameEntry[] _scores;

    // pre: n > 0, n represents the size of the array
    // post: there are n GameEntries stored.
    public ScoresArray(int n) {
	_scores = new GameEntry[n];
	for (int i = 0; i < n; i++) {
	    _scores[i] = new GameEntry();
	}
    }

    public ScoresArray() {
	this(10);
    }

    // O(n)
    // post: returns true if the entry is added.
    //       returns false otherwise
    //       if the entry is added, the entries 
    //       with a lower rank are shifted down
    public boolean add(GameEntry entry) {
	/*
	  boolean topTen = false;
	  int i = 0;
	  for (; i < numScores(); i++) {
	      if (entry.compareTo(_scores[i]) > 0) {
		  topTen = true;
		  break;
	      }
	  }
	  if (! topTen) return false;
	  _scores[numScores() - 1] = null;
	  for (int j = numScores() - 2; j >= i; j--) {
	      _scores[j+1] = _scores[j];
	  } 
	  _scores[i] = entry;
	  return true;
	*/
	  boolean ans = false;
	  for (int i = 0; i < numScores(); i++) {
	      if (entry.compareTo(_scores[i]) > 0) {
		  GameEntry temp = _scores[i];
		  _scores[i] = entry;
		  entry = temp;
		  ans = true;
	      }
	  }
	  return ans;
	 
    }

    public boolean addBS(GameEntry entry) {
	int high = 0;
	int low = numScores() - 1;
	return false;
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

    public GameEntry topEntry() {
	return _scores[0];
    }
    
    public int numScores() {
	return _scores.length;
    }

    public String toString() {
	String ans = "Rank\tInitials\tScore\n";
	for (int i = 0; i < numScores(); i++) {
	    ans += (i+1) + ".\t" + _scores[i] + "\n";
	}
	return ans;
    }

    public static void main(String[] args) {
	ScoresArray s = new ScoresArray(10);
	System.out.println(s);
	s.initialize(3, 2000);
	System.out.println(s);
	GameEntry a = GameEntry.randomEntry(3, 2000);	
	s.add(a);
	System.out.println(s);
    }

}
