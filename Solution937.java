import java.util.Arrays;
import java.util.Comparator;

class Solution937 {
  public String[] reorderLogFiles(String[] logs) {
    Comparator<String> logComparator = new Comparator<String>() {
      @Override
      public int compare(String log1, String log2) {
        String[] split1 = log1.split(" ", 2);
        String[] split2 = log2.split(" ", 2);

        boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
        boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

        if (isDigit1 && isDigit2) {
          return 0;
        } else if (!isDigit1 && isDigit2) {
          return -1;
        } else if (isDigit1 && !isDigit2) {
          return 1;
        } else {
          if (split1[1].compareTo(split2[1]) != 0) {
            return split1[1].compareTo(split2[1]);
          }
          return split1[0].compareTo(split2[0]);
        }

      }
    };

    Arrays.sort(logs, logComparator);
    return logs;
  }
}
