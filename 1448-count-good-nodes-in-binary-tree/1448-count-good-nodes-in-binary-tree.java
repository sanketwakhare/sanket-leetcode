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
    public int goodNodes(TreeNode root) {
        TreeNode parent = null;
        List<Integer> result = new ArrayList<>();
        traverse(root, parent, result);
        return result.size();        
    }
    
    public void traverse(TreeNode curr, TreeNode parent, List<Integer> result) {
        if(curr == null) return;
        // max represents max node value in path from root
        TreeNode max = curr;
        if(parent == null) {
            result.add(curr.val);
        } else {
            if(curr.val >= parent.val) {
                result.add(curr.val);
            }
            max = curr.val > parent.val ? curr : parent;
        }   
        traverse(curr.left, max, result);
        traverse(curr.right, max, result);
    }
}