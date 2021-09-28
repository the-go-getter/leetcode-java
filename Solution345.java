import java.util.HashSet;

public class Solution345 {
  public String reverseVowels(String s) {
    HashSet<Character> vowels = new HashSet<>();
    vowels.add('a');
    vowels.add('e');
    vowels.add('i');
    vowels.add('o');
    vowels.add('u');
    vowels.add('A');
    vowels.add('E');
    vowels.add('I');
    vowels.add('O');
    vowels.add('U');

    int left = 0;
    int right = s.length()-1;
    char [] word = s.toCharArray();

    while(left < right){
      while(left < right && !vowels.contains(word[left])){
        left++;
      }
      while(left < right && !vowels.contains(word[right])){
        right--;
      }
      char temp = word[left];
      word[left++]= word[right];
      word[right--] = temp;
    }
    return new String(word);
  }

  public static void main(String[] args) {
    Solution345 mySolution = new Solution345();
    System.out.println(mySolution.reverseVowels("hello"));
  }
}
