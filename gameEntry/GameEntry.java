public class GameEntry implements Comparable<GameEntry>{

    private String _initials;
    private int _score;

    public GameEntry() {
	_initials = "AAA";
	_score = 0;
    }

    public GameEntry(String initials, int socre) {
	_initials = initials;
	_score = score;
    }

    // accessor methods 
    public String getInitials() {
	return _initials;
    }

    public int getScore() {
	return _score;
    }
    
    public int compareTo(GameEntry rhs) {
	if (getScore() == rhs.getScore()) {
	    return getInitials().compareTo(rhs.getInitials());
	}
	return getScore() - rhs.getScore();
    }

    public String toString() {
	return _initials + " : " + _score;
    }

}
