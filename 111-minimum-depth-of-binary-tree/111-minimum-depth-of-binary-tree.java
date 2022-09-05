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
    public int minDepth(TreeNode root) {
        return traverse(root, 1);
    }
    
    public int traverse(TreeNode root, int level) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return level;
        }
        int x = Integer.MAX_VALUE;
        if(root.left != null) {
            x = traverse(root.left, level + 1);
        }
        int y = Integer.MAX_VALUE;
        if(root.right != null) {
            y = traverse(root.right, level + 1);
        }
        return Math.min(x, y);
    }
}