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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        first = null;
        second = null;
        prev = null;
        inorder(root);
        
        // swap data
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    // perofrm inorder and find culprit nodes
    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        if(prev != null && root.val < prev.val) {
            if(first == null) {
                // first culprit is previous node
                first = prev;
            }
            // second culprit is root node
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}