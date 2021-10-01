import java.util.HashMap;

class Solution387 {
  public int firstUniqChar(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    for(int i=0; i<s.length(); i++){
      char currentChar = s.charAt(i);
      if(map.containsKey(currentChar)){
        map.replace(currentChar, Integer.MAX_VALUE);
      } else{
        map.put(currentChar, i);
      }
    }

    int leastIndex = Integer.MAX_VALUE;
    for(char c: map.keySet()){
      if(map.get(c) < leastIndex){
        leastIndex = map.get(c);
      }
    }

    return leastIndex==Integer.MAX_VALUE ? -1:leastIndex;
  }
}