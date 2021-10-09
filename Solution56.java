import java.util.Arrays;
import java.util.PriorityQueue;

class Solution56 {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    maxHeap.add(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {
      int[] lastEnding = maxHeap.poll();
      if (lastEnding[1] >= intervals[i][0]) {
        lastEnding[1] = Math.max(lastEnding[1], intervals[i][1]);
      } else {
        maxHeap.add(intervals[i]);
      }
      maxHeap.add(lastEnding);
    }

    int[][] result = new int[maxHeap.size()][2];
    int index = 0;
    while (!maxHeap.isEmpty()) {
      result[index++] = maxHeap.poll();
    }

    return result;
  }
}
