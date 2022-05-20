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
    
    int maxSum = -2000;
    
    public int maxPathSum(TreeNode root) {
        
        maxSum = -2000;
        maxSum(root);
        return maxSum;
    }
    
    public int maxSum(TreeNode root) {
        
        if(root == null) {
            return 0;
        }
        
        int x = maxSum(root.left);
        int y = maxSum(root.right);
        
        int currMaxSum =  root.val;
        currMaxSum += Math.max(x, 0);
        currMaxSum += Math.max(y, 0);
        if(currMaxSum > maxSum) {
            maxSum = currMaxSum;
        }
        return root.val + Math.max(Math.max(x, y), 0);
    }
}