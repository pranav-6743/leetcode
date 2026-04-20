import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        // Push -1 as a starting base index for calculations
        stack.push(-1);
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // Store the index of the opening bracket
                stack.push(i);
            } else {
                // It's a closing bracket: pop the matching opening bracket
                stack.pop();
                
                if (stack.isEmpty()) {
                    // If stack is empty, this ')' is unmatched. 
                    // Push its index as the new base boundary.
                    stack.push(i);
                } else {
                    // Calculate length: current index minus the last unmatched index
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        
        return maxLength;
    }
}
