class Solution415 {
  public String addStrings(String num1, String num2) {
    StringBuilder result = new StringBuilder();
    int carry = 0;
    int numOneDigits = num1.length() - 1;
    int numTwoDigits = num2.length() - 1;

    while(numOneDigits >= 0 || numTwoDigits >= 0 || carry != 0){
      int digitOne = numOneDigits < 0 ? 0: num1.charAt(numOneDigits) - '0';
      int digitTwo = numTwoDigits < 0 ? 0:num2.charAt(numTwoDigits) - '0';
      int sum = digitOne + digitTwo + carry;
      carry = sum/10;
      sum = sum%10;
      result.append(sum);
      numOneDigits--;
      numTwoDigits--;
    }

    return result.reverse().toString();
  }
}
