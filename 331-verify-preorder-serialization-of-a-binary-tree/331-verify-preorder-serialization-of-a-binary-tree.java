class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        // System.out.println(Arrays.toString(strs));
                           
        Stack<String> stack = new Stack<>();
        int i = 0;
        int n = strs.length;
        while(i < n){
            String str = strs[i];
            if(stack.empty() || !"#".equals(str))
                stack.push(str);
            else {
                while(!stack.empty() && "#".equals(stack.peek())){
                    stack.pop();
                    if(stack.empty()) return false;
                    else stack.pop();
                }
                stack.push(str);
            }
            i++;
        }
        
        // System.out.println(stack);
        return stack.size() == 1 && "#".equals(stack.peek());
    }
}