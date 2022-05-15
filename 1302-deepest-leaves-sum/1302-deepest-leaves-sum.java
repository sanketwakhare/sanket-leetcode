/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        
        if(root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        
        List<Integer> level = new ArrayList<Integer>();
        int currSum = 0;
        
        while(queue.size() > 1) {
            
            TreeNode x = queue.poll();
            
            if(x == null) {
                // end of current level
                queue.add(null);
                currSum = 0;
            } else {
                currSum += x.val;
                level.add(x.val);
                
                if(x.left != null) {
                    queue.add(x.left);
                }
                if(x.right != null) {
                    queue.add(x.right);
                }
            }
            
        }
        return currSum;        
    }
}
