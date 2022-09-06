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
    public TreeNode pruneTree(TreeNode root) {
        prune(root, null);
        if(root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }
    
    public void prune(TreeNode root, TreeNode parent) {
        if(root == null) return;
        if(root.left != null)
            prune(root.left, root);
        if(root.right != null)
            prune(root.right, root);
        if(root.left == null && root.right == null && root.val == 0) {
            if(parent == null) {
                root = null;
            }
            else if(parent!=null && parent.left == root) {
                parent.left = null;
            }
            else if(parent!=null && parent.right == root) {
                parent.right = null;
            }
        }
    }
}