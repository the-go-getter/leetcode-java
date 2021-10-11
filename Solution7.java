class Solution7 {
  public int reverse(int x) {
    long result = 0;
    int digit;
    while(x != 0){
      digit = x%10;
      result = result*10 + digit;
      x = x/10;
    }

    if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
      return 0;
    } else{
      return (int)result;
    }
  }
}