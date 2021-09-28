import java.util.HashMap;
import java.util.HashSet;

public class Solution403 {
  public boolean canCross(int[] stones) {
    HashMap<Integer, HashSet<Integer>> jumps = new HashMap<>();
    for(int stone: stones){
      jumps.put(stone, new HashSet<Integer>());
    }

    jumps.get(0).add(0);

    for(int stone: stones){
      for(int jump: jumps.get(stone)){
        for(int possibleJump = jump-1; possibleJump<=jump+1; possibleJump++){
          if(possibleJump > 0 && jumps.containsKey(stone + possibleJump)){
            jumps.get(stone+possibleJump).add(possibleJump);
          }
        }
      }
    }
    return jumps.get(stones[stones.length - 1]).size() > 0;
  }

  public static void main(String[] args) {
    Solution403 mySolution = new Solution403();
    System.out.println(mySolution.canCross(new int[]{0,1,3,6,10,15,21,28}));
  }
}
