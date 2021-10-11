import java.util.HashMap;
import java.util.PriorityQueue;

class Solution347 {
  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> counts = new HashMap<>();
    for(int num: nums){
      counts.put(num, counts.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)-> counts.get(b) - counts.get(a));
    for(int num: counts.keySet()){
      maxHeap.add(num);
    }

    int[] result = new int[k];
    for(int i=0; i<result.length; i++){
      result[i] = maxHeap.remove();
    }

    return result;
  }
}