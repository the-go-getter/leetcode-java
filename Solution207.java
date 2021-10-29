import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution207 {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    HashMap<Integer, List<Integer>> dependents = new HashMap<>();
    int[] numPrereqs = new int[numCourses];
    Queue<Integer> freeCourses = new LinkedList<>();
    int completed = 0;

    for (int[] prereq : prerequisites) {
      if (!dependents.containsKey(prereq[1])) {
        dependents.put(prereq[1], new ArrayList<Integer>());
      }

      dependents.get(prereq[1]).add(prereq[0]);
      numPrereqs[prereq[0]]++;
    }

    for (int course = 0; course < numCourses; course++) {
      if (numPrereqs[course] == 0) {
        freeCourses.add(course);
      }
    }

    while (!freeCourses.isEmpty()) {
      int course = freeCourses.poll();
      completed++;
      if (dependents.containsKey(course)) {
        for (int dependent : dependents.get(course)) {
          numPrereqs[dependent]--;

          if (numPrereqs[dependent] == 0) {
            freeCourses.add(dependent);
          }
        }
      }
    }

    return completed == numCourses;
  }
}