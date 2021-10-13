public class Solution348 {
  class TicTacToe {
    int[] horizontalSum;
    int[] verticalSum;
    int diagonalSum;
    int antiDiagonalSum;
    int size;

    public TicTacToe(int n) {
      horizontalSum = new int[n];
      verticalSum = new int[n];
      diagonalSum = 0;
      antiDiagonalSum = 0;
      size = n;
    }

    public int move(int row, int col, int player) {
      int currMove = (player == 1) ? 1 : -1;

      horizontalSum[row] += currMove;
      verticalSum[col] += currMove;

      if (row == col) {
        diagonalSum += currMove;
      }

      if (row + col == size - 1) {
        antiDiagonalSum += currMove;
      }

      if (Math.abs(horizontalSum[row]) == size || Math.abs(verticalSum[col]) == size
              || Math.abs(diagonalSum) == size || Math.abs(antiDiagonalSum) == size) {
        return player;
      }
      return 0;
    }
  }

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
}
