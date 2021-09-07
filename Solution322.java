import java.util.Arrays;

public class Solution322 {
  public int coinChange(int[] coins, int amount) {
    int[] numCoins = new int[amount+1];
    Arrays.fill(numCoins, amount+1);
    Arrays.sort(coins);
    numCoins[0] = 0;
    for(int i = 1; i <= amount; i++){
      for(int j = 0; j < coins.length; j++){
        if(coins[j] <= i){
          numCoins[i] = Math.min(numCoins[i], 1 + numCoins[i - coins[j]]);
        } else{
          break;
        }
      }
    }
    return numCoins[amount]==amount+1 ? -1:numCoins[amount];
  }

  public static void main(String[] args) {
    Solution322 mySolution = new Solution322();
    System.out.println(mySolution.coinChange(new int[]{1, 2, 5}, 11));
  }
}


