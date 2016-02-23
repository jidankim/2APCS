public class NQueens{

    private int[][] _board;
    private int _n;

    // Creates a 8x8 board.
    public NQueens(){
	// Your code goes here
	_board = new int[8][8];
	_n = 0;
    }
    // Creates a n x n board
    public NQueens(int n){
	// Your code goes here
	_board = new int[n][n];
	_n = 0;
    }

    // Attempts to solve NQueens starting at position 0,0.
    // Calls solve(int,int).
    public void solve(){
	int N = _board.length;
	for (int i = 0; i <= N/2; i++)
	    for (int j = 0; j <= N/2; j++)
		if (solve(i,j)) {
		    return;
		}
		
    }

    // pre: _n < N*N
    // postcondition: returns true if NQueens is solved.
    //                false otherwise
    private boolean solve(int x, int y){
	try {
	    Thread.sleep(1);                 //1000 milliseconds is one second.
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	// Your code goes here.
	int N = _board.length;
	//check if out of bounds
	if (x < 0 || y < 0) return false;
	if (x >= N || y >= N) return false;
	//check if position is occupied
	if (_board[x][y] != 0) return false;
	//occupy position
	_board[x][y] = ++_n;
	//is it solved?
	if (_n == N*N) return true;
	System.out.println(this);
	//if not solved, continue down each path
	if (solve(x-2, y-1)) return true;
	if (solve(x-2, y+1)) return true;
	if (solve(x-1, y+2)) return true;
	if (solve(x+1, y+2)) return true;
	if (solve(x+2, y+1)) return true;
	if (solve(x+2, y-1)) return true;
	if (solve(x+1, y-2)) return true;
	if (solve(x-1, y-2)) return true;

	//No solution found, back track
	_board[x][y] = 0;
	System.out.println(this);
	_n--;
	return false;
    }

    public String toString(){
	String ans = "";
	for (int i = 0; i < _board.length; i++){
	    for (int j = 0; j < _board[i].length; j++){
		ans += _board[i][j] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String [] args){
	int N = Integer.parseInt(args[0]);
	NQueens q = new NQueens(N);
	q.solve();
	System.out.println(q);
    }


    
}
