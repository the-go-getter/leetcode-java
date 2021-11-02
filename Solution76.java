import java.util.HashMap;

class Solution76 {
  public String minWindow(String s, String t) {
    HashMap<Character, Integer> counts = new HashMap<>();

    for(char c: t.toCharArray()){
      int charCount = counts.getOrDefault(c, 0);
      counts.put(c, charCount+1);
    }

    int required = counts.size();
    int actual = 0;

    int left=0,right=0;
    int[] result = new int[]{Integer.MAX_VALUE, left, right};
    HashMap<Character, Integer> windowCounts = new HashMap<>();

    while(right<s.length()){
      char current = s.charAt(right);
      int currentCharCount = windowCounts.getOrDefault(current, 0);
      windowCounts.put(current, currentCharCount+1);

      if(counts.containsKey(current)
              && windowCounts.get(current).intValue()==counts.get(current).intValue()){
        actual++;
      }

      while(left<=right && actual==required){
        if(right-left+1 < result[0]){
          result[0] = right-left+1;
          result[1] = left;
          result[2] = right;
        }

        char eliminated = s.charAt(left);
        windowCounts.put(eliminated, windowCounts.get(eliminated)-1);

        if(counts.containsKey(eliminated)
                && windowCounts.get(eliminated)<counts.get(eliminated)){
          actual--;
        }
        left++;
      }
      right++;
    }

    return result[0]==Integer.MAX_VALUE ? "":s.substring(result[1], result[2]+1);
  }
}