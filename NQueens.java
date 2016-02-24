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
        for (int i = 0; i < N; i++)
            if (solve(i,0)) 
                return;
    }

    // pre: _n < N*N
    // postcondition: returns true if NQueens is solved.
    //                false otherwise
    private boolean solve(int x, int y){
	try {
	    Thread.sleep(10);                 //1000 milliseconds is one second.
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	// Your code goes here.
	int N = _board.length;
        //check if position is occupied
	if (_board[x][y] != 0) return false;
	//occupy position
	_board[x][y] = 2*N - 1;
        _n++;
        //mark all spaces protected by this queen
        markAll(x,y,true);
        //is it solved?
	if (_n == N) return true;
	System.out.println(this);
	//if not solved, continue down each path
        for (int i = 0; i < N; i++)
            if (_board[i][_n] == 0)
                if (solve(i, _n)) return true;
	//No solution found, back track
        markAll(x,y,false);
	_board[x][y] = 0;
	System.out.println(this);
	_n--;
	return false;
    }
    
    private void markAll(int x, int y, boolean mark) {
        int N = _board.length;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (i == x || j == y || j-i == y-x || j+i == y+x) {
                    if (mark) _board[i][j]++;
                    else _board[i][j]--;
                }
    }

    public String toString(){
	String ans = "";
        int N = _board.length;
	for (int i = 0; i < N; i++){
	    for (int j = 0; j < N; j++){
		if (_board[i][j] == 2*N) ans += "Q ";
                else ans += "- ";
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
