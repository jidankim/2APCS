public class TestProgression{

    public static void main(String [] args){
	int N = Integer.parseInt(args[0]);
	Progression prog = new Progression();
	Progression prog2 = new ArithmeticProgression(2);
	//Progression prog3 = new GeometricProgression(2);
	prog.printProgression(N);
	prog2.printProgression(N);
	//prog3.printProgression(N);


    }


}
