import java.util.HashMap;

class Solution13 {
  public int romanToInt(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    map.put('I',1);
    map.put('V',5);
    map.put('X',10);
    map.put('L',50);
    map.put('C',100);
    map.put('D',500);
    map.put('M',1000);

    int result=0;

    for(int i=0; i<s.length(); i++){
      char curr = s.charAt(i);
      if(i+1 < s.length()){
        char next = s.charAt(i+1);
        if(map.get(curr) < map.get(next)){
          result+= (map.get(next) - map.get(curr));
          i++;
          continue;
        }
      }

      result+=map.get(curr);

    }

    return result;
  }
}
