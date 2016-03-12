/*
Use a CircleList to build a game that simulates the classic Children's game
Duck, Duck, Goose.

In the game, the children sit in a circle. A child is chosen at random to 
be designated as "IT". "It" is removed from the circle then walks around
the circle declaring each child A "Duck" or a "Goose". If a child is declared
a "Goose", the "Goose" is removed from the circle. The "Goose's" position is
noted, then the "IT" and "Goose" race around the circle, whoever reaches 
the noted position first, occupies the noted position. The other child
remains as "IT" or becomes "IT" for the next round.

Ex. 

kids: Abe, Cal, Jen, Eve, Pam, Vern, Joe, Quin, Yuki
it: Jen
kids: Cal, Eve, Pam, Vern, Joe, Quin, Yuki, Abe 
Duck : Cal      
Duck : Eve
Duck: Pam
Goose: Vern
Race between Jen and Vern
kids:  Pam, Jen, Joe, Quin, Yuki, Abe, Cal, Eve
it : Vern

and the game continues.

Write the class DuckDuckGoose started below.
 */
import java.util.ArrayList;

public class DuckDuckGoose{

    private CircleList _circle;

    // Transfer the names from the ArrayList into a CircleList.
    public DuckDuckGoose(ArrayList<String> names){
	_circle = new CircleList();
	for (int i = 0; i < names.size(); i++)
	    _circle.add(new Node(names.get(i), null));
    }

    // Returns a randomly selected child to be it.
    // The child is removed from the circle and its node is returned.
    public Node chooseIt(){
	int n = (int)(Math.random()*_circle.size());
	for (int i = 0; i < n; i++)
	    _circle.advance();
	return _circle.remove();
    }

    public void play(int n) {
        System.out.println("kids: " + _circle);
	Node it = chooseIt();
	for (int i = 0; i < n; i++) {
            System.out.println("It: " + it);
            System.out.println("kids: " + _circle);
            while (Math.random() <= 0.75) {
                System.out.println("Duck: " + _circle.getCursor().getNext());
                _circle.advance();
            }
            System.out.println("Goose: " + _circle.getCursor().getNext());
            System.out.println("Race between: " + it + " and " + _circle.getCursor().getNext());
            if (Math.random() <= 0.5) {
                System.out.println(it + " wins race.");
                Node temp = it;
                it = _circle.getCursor().getNext();
                _circle.remove();
                _circle.add(temp);
            } else {
                System.out.println(_circle.getCursor().getNext() + " wins race.");
                _circle.advance();
            }
            System.out.println("kids: " + _circle);
	}
    }

    public String toString() {
	return _circle.toString();
    }

    public static void main(String [] args){
	int N = Integer.parseInt(args[0]);
	String [] n = {"Abe","Cal","Jen","Eve","Pam","Vern", "Joe", "Quin", "Yuki"};
	// Declare and instanciate an ArrayList of strings.
	ArrayList<String> a = new ArrayList<String>();
	// Copy the items of the String [] into an ArrayList of Strings.
	for (int i = 0; i < n.length; i++)
	    a.add(n[i]);
	// Declare and instantiate a DuckDuckGoose object.
	// The constructor's argument will be an ArrayList of Strings.
	DuckDuckGoose app = new DuckDuckGoose(a);
    	app.play(N);
    }



}
