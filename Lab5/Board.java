
public class Board {
	int[][] board = new int[8][8];
	Stack<Integer> placements = new Stack<Integer>();

	public Board() {
		for (int i=0; i < 8; i++) {
			for (int j=0; j < 8; j++) {
				board[i][j] = 0;
			}
		}
	}

	public String toString() {
		String retval = "";

		for (int j = 0; j < 8; j++) {
			for (int i=0; i < 8; i++) {
				retval = retval + ("[" + board[i][j] + "]");
			}
			retval = retval + "\n";
		}

		return retval;
	}

	public void solve_game() {
		boolean playing = true;
		int y = 0;
		int x = 0;


		while (playing) {
				if (x== 0) {
					placements.push(y);
					board[x][y] = 1;
					x++;
				}

				else if (x < 8) {

					y = solve_row_return_y(x, y);

					if (y != -1) {
						board[x][y] = 1;
						placements.push(y);
						x++;
						y = 0;
					}

					else {
						y = placements.pop();
						x--;
						board[x][y] = 0;
						y = y+1;
					}
				}


				else {
					playing = false;
				}
			}


	}

	public int solve_row_return_y(int x, int y) {
		if (y > 7) {
			return -1;
		}

		if (queen_in_path(x,y)) {
			return solve_row_return_y(x, y+1);
		}
		else  {
			return y;
		}
	}


	public boolean queen_in_path(int x, int y) {
		boolean in_path = false;

		/* check horizontal */
		for (int i = 0; i < 8; i++) {
			if ((i != x) && (board[i][y]==1) ) {
				in_path = true;
			}
		}

		/*check diagonal */
		for (int i=0; i < 8; i++) {
			for (int j=0; j < 8; j++) {
				if (!(i == x && j == y) && board[i][j]==1) {
					if ((x-y == i-j) || (x+y == i+j)) {
						in_path = true;
					}
				}
			}
		}




		return in_path;
	}

	public static void main(String[] args) {
		Board a = new Board();
		a.solve_game();
		System.out.println(a);

	}

}
