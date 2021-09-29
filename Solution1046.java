import java.util.PriorityQueue;

class Solution1046 {
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    for (int stone : stones) {
      maxHeap.add(stone);
    }

    while (maxHeap.size() > 1) {
      int stoneOne = maxHeap.poll();
      int stoneTwo = maxHeap.poll();
      int newStone = stoneOne - stoneTwo;

      if (newStone > 0) {
        maxHeap.add(newStone);
      }
    }

    return maxHeap.size() > 0 ? maxHeap.poll() : 0;
  }
}
