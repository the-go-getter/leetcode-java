import java.util.Stack;

public class Solution155 {
  class MinStack {
    Stack<Node> stack;

    public MinStack() {
      stack = new Stack<>();
    }

    public void push(int val) {
      if (stack.isEmpty()) {
        stack.push(new Node(val, val));
      } else {
        Node head = stack.peek();
        int currMin = head.min;
        if (val < currMin) {
          currMin = val;
        }
        stack.push(new Node(val, currMin));
      }
    }

    public void pop() {
      stack.pop();
    }

    public int top() {
      return stack.peek().val;
    }

    public int getMin() {
      return stack.peek().min;
    }

    class Node {
      int val;
      int min;

      Node(int val, int min) {
        this.val = val;
        this.min = min;
      }
    }
  }
}
