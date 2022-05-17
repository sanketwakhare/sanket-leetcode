/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        return preOrder(original, cloned, target);
    }
    
    public TreeNode preOrder(TreeNode original, TreeNode cloned, TreeNode target) {
        
        if(original == null) {
            return null;
        }
        
        if(original == target) {
            return cloned;
        }
        TreeNode x = preOrder(original.left, cloned.left, target);
        if(x !=null) {
            return x;
        }
        TreeNode y = preOrder(original.right, cloned.right, target);
        if(y !=null) {
            return y;
        }
        return null;
    }
}