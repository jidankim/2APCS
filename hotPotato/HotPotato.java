public class HotPotato {

	private Queue<String> _players;
	
	public HotPotato(String[] names) {
		_players = new ArrayQueue<String>(names.length);
		for (String name : names)
			_players.enqueue(name);
	}

	public void play(double chance) {
		String removed;
		int N = _players.size();
		System.out.println("Children: " + _players);
		while (N > 1) {
			double r = Math.random();
			removed = _players.dequeue();
			if (r < chance) {
				System.out.println("Hot potato: " + removed);
			} else {
				_players.enqueue(removed);
				System.out.println("Potato: " + removed);
			}
			System.out.println("Children: " + _players);
			N = _players.size();
		}
		System.out.println("Winner: " + _players.front());
	}

	public String toString() {
		return _players.toString();
	}


    	public static void main(String[] args){
		String [] names = {"Bobby","Sue", "Amy", "Mark", "Danny", "Kelly", "Yuki"};
		HotPotato game = new HotPotato(names);
		double chance = Double.parseDouble(args[0]);
		game.play(chance);
	}

}
