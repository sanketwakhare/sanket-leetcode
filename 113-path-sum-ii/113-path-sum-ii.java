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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        int sum = 0;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        traverse(root, targetSum, sum, result, path);
        return result;
    }
    
    public void traverse(TreeNode root, int targetSum, int sum, List<List<Integer>> result, List<Integer> path)  {
        if(root == null) return;
        
        path.add(root.val);
        sum += root.val;
        if(root.left == null && root.right == null) {
            // leaf node
            if(targetSum == sum) {
                result.add(new ArrayList(path));
            }
            path.remove(path.size() - 1);
            return;
        }     
        traverse(root.left, targetSum, sum, result, path);
        traverse(root.right, targetSum, sum, result, path);
        if(path.size() > 1){
            path.remove(path.size() - 1);
        }
    }
}