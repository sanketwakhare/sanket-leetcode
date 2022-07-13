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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        traverse(1, root, result);
        return result;
    }
    
    private void traverse(int level, TreeNode root, List<List<Integer>> result) {
        // base case
        if(root == null) return;
        // insert new for current level if not already present
        if(result.size() < level) {
            result.add(0, new LinkedList<Integer>());
        }
        // left subtree
        traverse(level + 1, root.left, result);
        // right subtree
        traverse(level + 1, root.right, result);
        // insert current root into current level, result has 0-based index
        // insert root at corresponding list in reverse direction
        result.get((result.size() - 1) - (level - 1)).add(root.val);
    }
}