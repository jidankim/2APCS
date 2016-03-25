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

    public boolean add2(GameEntry entry) {
	for (int i = 0; i < _scores.length; i++) {
	    if (entry.compareTo(_scores[i]) > 0) {
		GameEntry t = _scores[i];
		_scores[i] = entry;
		while(++i < _scores.length) {
		    entry = t;
		    t = _scores[i];
		    _scores[i] = entry;
		}
		return true;
	    }
	}
	return false;
    } 

    // starts at the bottom, best
    public boolean add3(GameEntry entry) {
	int N = numScores();
	if (entry.compareTo(_scores[N-1]) <= 0)
	    return false;
	for (int i = N-1; i >0; i--) {
	    _scores[i] = _scores[i-1];
	    if (entry.compareTo(_scores[i]) < 0) {
		_scores[i] = entry;
		return true;
	    }
	}
	_scores[0] = entry;
	return true;
    }

    // use a modified binary search to find the insertion point
    public boolean addBS(GameEntry entry) {
	int lower = 0;
	int upper = numScores();
	int pos = (lower + upper) / 2;
	while (lower < upper) {
	    if (entry.compareTo(_scores[pos]) > 0) {
		if (pos == 0 || entry.compareTo(_scores[pos - 1]) < 0)
		    break;
		else upper = pos - 1;
	    } else lower = pos + 1;
	    pos = (lower + upper) / 2;
	}
	if (pos >= numScores()) return false;
	while (pos < numScores()) {
	    GameEntry t = _scores[pos];
	    _scores[pos++] = entry;
	    entry = t;
	}
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
	s.initialize(3, 1000);
	System.out.println(s);
	GameEntry a = GameEntry.randomEntry(3, 2000);	
	s.add(a);
	System.out.println(s);
    }

}
