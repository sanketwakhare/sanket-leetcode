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
    public int findBottomLeftValue(TreeNode root) {
        // result[0] = maxLevel
        // result[1] = answer
        int[] result = new int[] {0, 0};
        
        traverse(root, 1, result);
        return result[1];
    }
    
    public void traverse(TreeNode root, int level, int[] result) {
        
        // base condition
        
        if(root == null) return;
        
        if(level > result[0]) {
            // if current level is max level till this point, update answer and max level
            result[0] = level;
            result[1] = root.val;
        }
        
        // traverse left subtree
        traverse(root.left, level + 1, result);
        // traverse right subtree
        traverse(root.right, level + 1, result);
    }
}