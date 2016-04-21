public class Fish extends Animal {

    public Fish(Ecosystem eco, int pos) {
	super(eco, pos);
    }

    public void interact(Animal other) {
	if (other instanceof Bear)
	    interact((Bear)other);
	else interact((Fish)other);
    }

    public void interact(Fish other) {
	int r = offSpringPos();
	if (r != -1) {
	    _river[r] = new Fish(_eco, r);
	    _eco.updateSize(1);
	}
    }

    public void interact(Bear other) {
	die();
    }

    public String toString() {
	return "F";
    }

}
