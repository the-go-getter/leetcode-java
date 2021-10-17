import java.util.HashMap;
import java.util.PriorityQueue;

class Solution767 {
  public String reorganizeString(String s) {
    HashMap<Character, Integer> counts = new HashMap<>();
    PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> counts.get(b) - counts.get(a));
    for (char c : s.toCharArray()) {
      counts.put(c, counts.getOrDefault(c, 0) + 1);
    }

    for (char c : counts.keySet()) {
      maxHeap.add(c);
    }

    StringBuilder result = new StringBuilder();
    while (maxHeap.size() > 1) {
      char current = maxHeap.poll();
      char next = maxHeap.poll();

      result.append(current);
      result.append(next);

      counts.put(current, counts.get(current) - 1);
      counts.put(next, counts.get(next) - 1);

      if (counts.get(current) != 0) {
        maxHeap.add(current);
      } else {
        counts.remove(current);
      }

      if (counts.get(next) != 0) {
        maxHeap.add(next);
      } else {
        counts.remove(next);
      }
    }

    char last = ' ';
    if (!maxHeap.isEmpty()) {
      last = maxHeap.peek();
      result.append(last);
    }

    if (maxHeap.isEmpty() || counts.get(last) == 1) {
      return result.toString();
    }

    return "";

  }
}