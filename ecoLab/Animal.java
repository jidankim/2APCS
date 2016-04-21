public abstract class Animal {
    
    protected Ecosystem _eco;
    protected Animal[] _river;
    protected int _currentPos;

    public Animal(Ecosystem eco, int pos) {
	_eco = eco;
	_river = eco.getRiver();
	_currentPos = pos;
    }

    public void move() {
	int[] deltas = {-1, 0, 1};
	int r = (int)(Math.random() * deltas.length);
	int dx = deltas[r];
	int nextPos = _currentPos + dx;
	if (nextPos < 0 || nextPos >= _river.length)
	    nextPos = _currentPos;
	else if (nextPos != _currentPos && _river[nextPos] != null)
	    interact(_river[nextPos]);
	else {
	    _river[_currentPos] = null;
	    _currentPos = nextPos;
	    _river[_currentPos] = this;
	}
    }

    public abstract void interact(Animal other);

    public int offSpringPos() {
	int r = _eco.getRandomPos();
	if (r == -1) return -1;
	return r;
    }

    public void die() {
	_river[_currentPos] = null;
	_eco.updateSize(-1);
    }
    
}
