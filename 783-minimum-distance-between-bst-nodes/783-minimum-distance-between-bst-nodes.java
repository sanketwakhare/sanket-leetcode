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
    public int minDiffInBST(TreeNode root) {
        // inorder of BST is sorted
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        int min = Integer.MAX_VALUE;
        for(int i=1; i<res.size(); i++) {
            min = Math.min(min, res.get(i) - res.get(i-1));
        }
        return min;
    }
    
    public void inorder(TreeNode root, List<Integer> res)  {
        if(root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}