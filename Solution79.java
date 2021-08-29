public class Solution79 {
  public boolean exist(char[][] board, String word) {

    char[] words = word.toCharArray();
    boolean output = false;
    for (int m = 0; m < board.length; m++) {
      for (int n = 0; n < board[m].length; n++) {
        if (board[m][n] == words[0]) {
          output = output || dfs(board, words, m, n, 0, output);
        }
      }
    }
    return output;
  }

  public boolean dfs(char[][] board, char[] words, int row, int col, int index, boolean result) {
    if (index == words.length) {
      return true;
    } else if (row < 0 || row > board.length - 1 || col < 0 || col > board[row].length - 1 || board[row][col] != words[index]) {
      return false;
    } else {
      char current = board[row][col];
      board[row][col] = ' ';
      result = dfs(board, words, row - 1, col, index + 1, result) ||
              dfs(board, words, row, col - 1, index + 1, result) ||
              dfs(board, words, row + 1, col, index + 1, result) ||
              dfs(board, words, row, col + 1, index + 1, result) ||
              result;
      board[row][col] = current;
      return result;
    }
  }
}
