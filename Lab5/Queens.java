public class Queens{
  int n = 8;
  Stack<Integer> s = new Stack<>();
  int[][] chessBoard = new int[n][n];

  //construct board
  public Queens(){
    for (int i = 0; i < 8; i++)
      for (int k = 0; k < 8; k++)
        chessBoard[i][k] = 0;
  }\
  // display
  public void display(){
    String place = "";

    for (int i = 0; i < 8; i++){
      for (int k = 0; k < 8; k++){
        if (chessBoard[i][k] == 1)
          place +=  "Q ";
        else
          place += "* ";
      }
      place += "\n";
    }
    System.out.println(place);
  }
  // handles playing the game
  public boolean play(){
    int x = 0, y = 0;

    while (true){
      if (x == 0){
        s.push(y);
        chessBoard[x][y] = 1;
        x++;
      }
      else if (x < 8){
        y = row(x, y);

        if (y != -1){
          chessBoard[x][y] = 1;
          s.push(y);
          x++;
          y = 0;
        }
        else{
          y = s.pop();
          x--;
          chessBoard[x][y] = 0;
          y = y + 1;
        }
      }
      else{
        break;
      }
    }
    return true;
  }

  public int row(int x, int y){
    if (y > 7)
      return -1;
    if (inTheWay(x, y))
      return row(x, y+1);
    else
      return y;
  }

  public boolean inTheWay(int x, int y){
    boolean inWay = false;
		for (int i = 0; i < 8; i++)
			if ((i != x) && (chessBoard[i][y] == 1))
				inWay = true;
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				if (!(i == x && j == y) && chessBoard[i][j] == 1)
					if ((x - y == i - j) || (x + y == i + j))
						inWay = true;
		return inWay;
  }

  public static void main(String[] args){
    Queens game = new Queens();
		game.play();
    game.display();
  }
}
