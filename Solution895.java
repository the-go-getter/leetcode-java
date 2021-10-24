import java.util.HashMap;
import java.util.Stack;

public class Solution895 {
  class FreqStack {
    HashMap<Integer, Stack<Integer>> frequencyMap;
    HashMap<Integer, Integer> counts;
    int max;

    public FreqStack() {
      frequencyMap = new HashMap<>();
      counts = new HashMap<>();
      max = Integer.MIN_VALUE;
    }

    public void push(int val) {
      if (!counts.containsKey(val)) {
        counts.put(val, 1);
      } else {
        counts.put(val, counts.get(val) + 1);
      }

      int currFrequecy = counts.get(val);
      if (currFrequecy > max) {
        frequencyMap.put(currFrequecy, new Stack<Integer>());
        frequencyMap.get(currFrequecy).push(val);
        max = currFrequecy;
      } else {
        frequencyMap.get(currFrequecy).push(val);
      }

    }

    public int pop() {
      int output = frequencyMap.get(max).pop();
      counts.put(output, counts.get(output) - 1);
      if (frequencyMap.get(max).isEmpty()) {
        frequencyMap.remove(max);
        max--;
      }

      return output;
    }
  }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
}
