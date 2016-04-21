public class Bear extends Animal {

    public Bear(Ecosystem eco, int pos) {
	super(eco, pos);
    }

    public void interact(Animal other) {
	if (other instanceof Bear) interact((Bear)other);
	else interact((Fish)other);
    }

    public void interact(Bear other) {
	int r = offSpringPos();
	if (r != -1) {
	    _river[r] = new Bear(_eco, r);
	    _eco.updateSize(1);
	}
    }

    public void interact(Fish other) {
	other.die();
    }
    
    public String toString() {
	return "B";
    }

}
