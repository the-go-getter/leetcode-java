class Solution121 {
  public int maxProfit(int[] prices) {
    int profit = 0;
    int minPrice = Integer.MAX_VALUE;
    for(int i=0; i<prices.length; i++){
      if(prices[i] < minPrice){
        minPrice = prices[i];
      }

      if(prices[i] - minPrice > profit){
        profit = prices[i] - minPrice;
      }
    }
    return profit;
  }
}
