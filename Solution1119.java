import java.util.HashSet;

public class Solution1119 {
  public String removeVowels(String s) {
    HashSet<Character> vowels = new HashSet<>();
    vowels.add('a');
    vowels.add('e');
    vowels.add('i');
    vowels.add('o');
    vowels.add('u');

    String result = "";
    for(char letter : s.toCharArray()){
      if(vowels.contains(letter)){
        continue;
      } else {
        result += letter;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Solution1119 mySolution = new Solution1119();
    System.out.println(mySolution.removeVowels("java python sql"));
  }
}
