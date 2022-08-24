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
    int answer = 0;
    int maxLevel = 0;
    public int findBottomLeftValue(TreeNode root) {
        traverse(root, 1);
        return answer;
    }
    
    public void traverse(TreeNode root, int level) {
        
        if(root == null) return;
        
        if(level > maxLevel) {
            maxLevel = level;
            answer = root.val;
        }
        
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }
}