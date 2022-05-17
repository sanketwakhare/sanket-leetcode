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
    int sum = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        sum = 0;
        if(root == null) return false;
        return hasSum(root, targetSum);
    }
    
    public boolean hasSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) {
            // leaf found
            if(sum + root.val == targetSum) {
                return true;
            } else {
                return false;
            }
        }
        
        sum += root.val;
        boolean x = hasSum(root.left, targetSum);
        if(x) {
            return true;
        }
        boolean y = hasSum(root.right, targetSum);
        if(y) {
            return true;
        }
        sum -= root.val;
        return false;
    }
}