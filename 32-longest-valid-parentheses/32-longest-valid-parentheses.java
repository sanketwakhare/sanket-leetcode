class Solution {
    public int longestValidParentheses(String s) {
        int maxCount = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxCount = Math.max(maxCount, i - stack.peek());
                }
            }
        }
        return maxCount;
    }
}