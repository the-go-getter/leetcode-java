import java.util.HashSet;

public class Solution929 {
  public static int numUniqueEmails(String[] emails) {
    HashSet<String> uniqueEmails = new HashSet<>();
    for (String email : emails) {
      String[] emailParts = email.split("@");
      StringBuilder localName = new StringBuilder();
      for (int i = 0; i < emailParts[0].length(); i++) {
        char letter = emailParts[0].charAt(i);
        if (letter == '.') {
          continue;
        } else if (letter == '+') {
          break;
        } else {
          localName.append(letter);
        }
      }
      String finalEmail = localName + "@" + emailParts[1];
      uniqueEmails.add(finalEmail);
    }
    return uniqueEmails.size();
  }

  public static void main(String[] args) {
    Solution929 mySolution = new Solution929();
    System.out.println(mySolution.numUniqueEmails(new String[]{"test.email+alex@leetcode.com",
            "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
  }
}
