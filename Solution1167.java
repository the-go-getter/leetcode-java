import java.util.PriorityQueue;

class Solution1167 {
  public int connectSticks(int[] sticks) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for(int stick:sticks){
      minHeap.add(stick);
    }

    int cost = 0;
    while(minHeap.size() > 1){
      int stickOne = minHeap.poll();
      int stickTwo = minHeap.poll();
      cost += stickOne;
      cost += stickTwo;
      minHeap.add(stickOne+stickTwo);
    }

    return cost;
  }
}
