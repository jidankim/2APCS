import java.util.List;
import java.util.ArrayList;

public class Tower extends NodeStack<Disk> {

    private int _maxRadius;

    public Tower() {
	super();
	_maxRadius = 0;
    }

    public void push(Disk d) {
	if (d.getRadius() > _maxRadius)
	    _maxRadius = d.getRadius();
	super.push(d);
    }

    public Disk pop() throws EmptyStackException {
	Disk t = super.pop();
	if (t.getRadius() == _maxRadius) {
	    if (isEmpty()) _maxRadius = 0;
	    else _maxRadius = top().getRadius();
	}
	return t;
    }

    public String toString() {
	String ans = "\n";
	String temp = super.toString();
	// remove []
	temp = temp.substring(1, temp.
    }

}
