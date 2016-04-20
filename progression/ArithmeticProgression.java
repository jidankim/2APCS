public class ArithmeticProgression extends Progression {

    private int _inc;
    
    public ArithmeticProgression(int increment) {
	super();
	_inc = increment;
    }

    public int nextValue() {
	_curr += _inc;
	return _curr;
    }

}
