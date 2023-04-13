class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        Stack<Integer> stack = new Stack<>();
        int poppedPtr = 0;
        
        for(int pushedEle: pushed) {
            stack.push(pushedEle);
            while(!stack.isEmpty() && poppedPtr < popped.length && stack.peek() == popped[poppedPtr]) {
                stack.pop();
                poppedPtr++;
            }
        }
        
        return stack.isEmpty();
    }
}
