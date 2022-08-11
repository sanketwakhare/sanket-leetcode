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
    public boolean isValidBST(TreeNode root) {
        
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        // System.out.println(inorder);
        
        for(int i=0; i<inorder.size()-1; i++) {
            if(inorder.get(i) >= inorder.get(i+1)) return false;
        }
        return true;
        
    }
    
    public void inorderTraversal(TreeNode root, List<Integer> inorder) {
        if(root == null) return;
        inorderTraversal(root.left, inorder);
        inorder.add(root.val);
        inorderTraversal(root.right, inorder);
    }
}