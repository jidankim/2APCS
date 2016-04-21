public class Ecosystem {

    private Animal[] _river;
    private int _size;

    // pre: capacity is the length of the river
    public Ecosystem(int capacity) {
	_river = new Animal[capacity];
	_size = 0;
    }

    // pre: numBears + numFish < capacity
    // post: populates the river with bears and fish
    public Ecosystem(int capacity, int numBears, int numFish) {
	this(capacity);
	_size = numBears + numFish;
	Bear b = new Bear(this, -1);
	while (numBears-- > 0) b.interact(b);
	Fish f = new Fish(this, -1);
	while (numFish-- > 0) f.interact(f);
    }

    // post: return a random open location in the river
    //       returns -1 if the river is full
    public int getRandomPos() {
	int r = -1;
	// find open position
	if (!isFull()) {
	    r = (int)(Math.random() * _river.length);
	    while(_river[r] != null) {
		r = floorMod(r+1, _river.length);
	    }
	}
	return r;
    }

    public Animal[] getRiver() {
	return _river;
    }

    public int size() {
	return _size;
    }
    
    public boolean isFull() {
	return size() == _river.length;
    }

    public int updateSize(int ds) {
	if (!isFull()) _size += ds;
	return size();
    }

    public void step() {
	for (Animal a : _river)
	    if (a != null) a.move();
    }

    public int countBears() {
	int ans = 0;
	for (Animal a : _river)
	    if (a instanceof Bear) ans++;
	return ans;
    }

    public int countFish() {
	int ans = 0;
	for (Animal a : _river)
	    if (a instanceof Fish) ans++;
	return ans;
    }

    public String toString() {
	String ans = "|";
	for (Animal a : _river) {
	    if (a != null)
		ans += a;
	    else 
		ans += "_";
	}
	ans += "|" + "# bears: " + countBears() + " # fish: " + countFish();
	return ans;
    }

    private static int floorMod(double n, double d) {
	return (int) (n - d * Math.floor(n/d));
    }

    public static void main(Stirng[] args) {
	Ecosystem eco = new Ecosystem(65, 3, 10);
	int N = Integer.parseInt(args[0]);
	System.out.println(eco);
	for (int i = 0; i < N; i++) {
	    eco.step();
	    System.out.println(eco);
	}
    }

}
