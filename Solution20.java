import java.util.HashMap;
import java.util.Stack;

class Solution20 {
  public boolean isValid(String s) {
    HashMap<Character, Character> map = new HashMap<>();
    map.put('(',')');
    map.put('[',']');
    map.put('{','}');
    Stack<Character> stack = new Stack<>();
    for(char parentheses: s.toCharArray()){
      if(map.containsKey(parentheses)){
        stack.push(parentheses);
      } else if(!stack.isEmpty() && parentheses == map.get(stack.pop())){
        continue;
      } else{
        return false;
      }
    }
    return stack.isEmpty();
  }
}