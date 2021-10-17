import java.util.PriorityQueue;

public class Solution295 {
  class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
      this.minHeap = new PriorityQueue<>();
      this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
      minHeap.add(num);
      maxHeap.add(minHeap.poll());

      if (maxHeap.size() > minHeap.size()) {
        minHeap.add(maxHeap.poll());
      }
    }

    public double findMedian() {
      int size = minHeap.size() + maxHeap.size();
      return size % 2 == 0 ? (minHeap.peek() + maxHeap.peek()) / 2.0 : minHeap.peek() / 1.0;
    }
  }
}
