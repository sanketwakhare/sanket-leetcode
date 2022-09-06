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
    public boolean isBalanced(TreeNode root) {
        return height(root) == Integer.MIN_VALUE ? false : true;
    }
    
    public int height(TreeNode root) {
        if(root == null) return -1;
        int x = height(root.left);
        if(x == Integer.MIN_VALUE)  return x;
        int y = height(root.right);
        if(y == Integer.MIN_VALUE)  return y;
        if(x > y && x - y > 1) return Integer.MIN_VALUE;
        if(y > x && y - x > 1) return Integer.MIN_VALUE;
        return Math.max(x, y) + 1;
    }
}