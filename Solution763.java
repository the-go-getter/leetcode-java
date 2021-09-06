import java.util.ArrayList;
import java.util.List;

public class Solution763 {
  public List<Integer> partitionLabels(String s) {
    List<Integer> result = new ArrayList<>();
    int [] lastPos = new int[26];
    for(int i =0; i< s.length(); i++){
      lastPos[s.charAt(i) - 'a'] = i;
    }

    int i = 0;
    int partition = lastPos[s.charAt(0) - 'a'];
    int prevPartition = -1;
    while(i < s.length()){
      int currCharLastPos = lastPos[s.charAt(i) - 'a'];
      if(i == partition){
        result.add(i-prevPartition);
        prevPartition = partition;
        i++;
      } else if (currCharLastPos > partition){
        partition = currCharLastPos;
      } else {
        i++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Solution763 mySolution = new Solution763();
    System.out.println(mySolution.partitionLabels("ababcbacadefegdehijhklij"));
  }
}
