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
    public TreeNode searchBST(TreeNode root, int val) {
            
        return traverseBST(root, val);
        
    }
    
    public TreeNode traverseBST(TreeNode root, int k) {
        if(root == null) {
            return null;
        }
        if(root.val == k) {
            return root;
        }
        if(root.val > k) {
            // search on left subtree
            return traverseBST(root.left, k);
        } 
        // search on right subtree
        return traverseBST(root.right, k);
    }
}