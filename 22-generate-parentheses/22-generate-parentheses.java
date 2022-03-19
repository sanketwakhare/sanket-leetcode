class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        solve(1, n, 1, 0, sb, list);
        return list;
    }
    
    public void solve(int level, int n, int leftCount, int rightCount, StringBuilder sb, List<String> list) {
        
        // base condition
        if (level == 2 * n && leftCount == rightCount) {
            // valid parenthesis
            String temp = sb.toString();
            list.add(temp);
        }

        if (rightCount > leftCount) {
            return;
        }
        if (leftCount > n) {
            return;
        }

        sb.append('(');
        solve(level + 1, n, leftCount + 1, rightCount, sb, list);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        solve(level + 1, n, leftCount, rightCount + 1, sb, list);
        sb.deleteCharAt(sb.length() - 1);
    }
}