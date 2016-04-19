public class Disk implements Comparable<Disk> {

    private int _radius;
    
    public Disk() {
	_radius = 1;
    }

    public Disk(int r) {
	_radius = r;
    }

    public int getRadius() {
	return _radius;
    }

    public int compareTo(Disk rhs) {
	return _radius - rhs._radius;
    }
    
    public String toString() {
	String ans = "*";
	for (int i = 1; i < _radius; i++) {
	    ans += "**";
	}
	return ans;
    }

    public static void main(String[] args) {
	Disk max = new Disk();
	for (int i = 0; i < 10; i++) {
	    Disk d = new Disk((int) (Math.random() * 5) + 1);
	    System.out.println("old max: " + max);
	    System.out.println("new disk: " + d);
	    if (d.compareTo(max) > 0) {
		max = d;
		System.out.println("\tnew max: " + max);
	    }
	}
    }

}
