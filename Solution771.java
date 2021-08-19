import java.util.HashSet;

public class Solution771 {
  public static int numJewelsInStones(String jewels, String stones) {
    HashSet<Character> jewelSet = new HashSet<>();
    int result = 0;
    for(char jewel: jewels.toCharArray()){
      jewelSet.add(jewel);
    }

    for(char stone: stones.toCharArray()) {
      if (jewelSet.contains(stone)) {
        result++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Solution771.numJewelsInStones("aA","aAAbbbb"));
  }
}
