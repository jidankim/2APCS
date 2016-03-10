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

    // *** Question 4 ****
    // Transfer the names from the ArrayList into a CircleList.
    public DuckDuckGoose(ArrayList<String> names){
	_circle = new CircleList();
	for (int i = 0; i < names.size(); i++)
	    _circle.add(new Node(names.get(i), null));
    }

    // *** Question 5 ****
    // Returns a randomly selected child to be it.
    // The child is removed from the circle and its node is returned.
    public Node chooseIt(){
	int n = (int)(Math.random()*_circle.size());
	for (int i = 0; i < n; i++)
	    _circle.advance();
	return _circle.remove();
    }

    /*
Whoever is "It" designates a kid as a Duck with probability 0.75; otherwise
the designation is Goose with probability 0.25.

Below is a sample run after 5 rounds:

kids: [Abe, Yuki, Quin, Joe, Vern, Pam, Eve, Jen, Cal]
It: Abe
kids: [Cal, Yuki, Quin, Joe, Vern, Pam, Eve, Jen]
Duck: Yuki
Duck: Quin
Duck: Joe
Duck: Vern
Duck: Pam
Goose: Eve
Race between: Abe and Eve
Abe wins race.
kids: [Abe, Jen, Cal, Yuki, Quin, Joe, Vern, Pam]
It: Eve
kids: [Abe, Jen, Cal, Yuki, Quin, Joe, Vern, Pam]
Goose: Jen
Race between: Eve and Jen
Eve wins race.
kids: [Eve, Cal, Yuki, Quin, Joe, Vern, Pam, Abe]
It: Jen
kids: [Eve, Cal, Yuki, Quin, Joe, Vern, Pam, Abe]
Duck: Cal
Duck: Yuki
Duck: Quin
Duck: Joe
Goose: Vern
Race between: Jen and Vern
Vern wins race.
kids: [Vern, Pam, Abe, Eve, Cal, Yuki, Quin, Joe]
It: Jen
kids: [Vern, Pam, Abe, Eve, Cal, Yuki, Quin, Joe]
Duck: Pam
Goose: Abe
Race between: Jen and Abe
Abe wins race.
kids: [Abe, Eve, Cal, Yuki, Quin, Joe, Vern, Pam]
It: Jen
kids: [Abe, Eve, Cal, Yuki, Quin, Joe, Vern, Pam]
Duck: Eve
Goose: Cal
Race between: Jen and Cal
Jen wins race.
kids: [Jen, Yuki, Quin, Joe, Vern, Pam, Abe, Eve]
     */
    public void play(int n) {
	Node it = chooseIt();
	for (int i = 0; i < n; i++) {
	    System.out.println(_circle);
	}
    }

    public String toString() {
	return _circle.toString();
    }

    public static void main(String [] args){
	int N = Integer.parseInt(args[0]);
	String [] n = {"Abe","Cal","Jen","Eve","Pam","Vern", "Joe", "Quin", "Yuki"};
	// *** Question 1 *** 
	// Declare and instanciate an ArrayList of strings.
	ArrayList<String> a = new ArrayList<String>();
	// *** Question 2 ***
	// Copy the items of the String [] into an ArrayList of Strings.
	for (int i = 0; i < n.length; i++)
	    a.add(n[i]);
	// *** Question 3 ****
	// Declare and instantiate a DuckDuckGoose object.
	// The constructor's argument will be an ArrayList of Strings.
	DuckDuckGoose app = new DuckDuckGoose(a);
	//	app.play(N);
    }



}
