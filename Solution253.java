import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution253 {
  public int minMeetingRooms(int[][] intervals) {
    PriorityQueue<int[]> rooms = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
    rooms.add(intervals[0]);
    for(int i =1; i< intervals.length; i++){
      int[] interval = intervals[i];
      int[] earliestEndingInterval = rooms.poll();
      if (interval[0] >= earliestEndingInterval[1]){
        earliestEndingInterval[1] = interval[1];
      } else {
        rooms.add(interval);
      }
      rooms.add(earliestEndingInterval);
    }
    return rooms.size();
  }
}
