class Solution8 {
  public int myAtoi(String s) {
    int i = 0;

    while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
      i++;
    }

    boolean positive = true;
    if (i < s.length() && s.charAt(i) == '-') {
      positive = false;
      i++;
    } else if (i < s.length() && s.charAt(i) == '+') {
      positive = true;
      i++;
    }

    if (i < s.length() && Character.isLetter(s.charAt(i))) {
      return 0;
    }

    long parsedResult = 0;

    while (i < s.length() && Character.isDigit(s.charAt(i))) {
      int digit = s.charAt(i) - '0';
      parsedResult = parsedResult * 10 + digit;
      i++;

      if (positive && parsedResult > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      } else if (-1 * parsedResult < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }

    }

    parsedResult = positive ? parsedResult : parsedResult * -1;
    return (int) parsedResult;
  }
}