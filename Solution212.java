import java.util.ArrayList;
import java.util.List;

class Solution212 {
  public List<String> findWords(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();

    for (String word : words) {
      for (int row = 0; row < board.length; row++) {
        for (int col = 0; col < board[row].length; col++) {
          if (board[row][col] == word.charAt(0) && dfs(board, word, row, col, 0)) {
            result.add(word);
            //Since we don't wish to search for the same word again
            row = board.length - 1;
            col = board[row].length - 1;
          }
        }
      }
    }

    return result;
  }

  public boolean dfs(char[][] board, String word, int row, int col, int index) {
    if (index == word.length()) {
      return true;
    }

    if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] != word.charAt(index)) {
      return false;
    }

    char temp = board[row][col];
    board[row][col] = ' ';
    boolean output = dfs(board, word, row + 1, col, index + 1) || dfs(board, word, row - 1, col, index + 1) ||
            dfs(board, word, row, col + 1, index + 1) || dfs(board, word, row, col - 1, index + 1);
    board[row][col] = temp;

    return output;
  }
}