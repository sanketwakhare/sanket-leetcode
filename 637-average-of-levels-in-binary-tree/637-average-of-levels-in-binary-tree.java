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
    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        List<Double> result = new ArrayList<>();
        
        traverse(root, 1, levels);
        
        for(List<Integer> currLevel : levels) {
            double sum = 0;
            for(int ele : currLevel) {
                sum += ele;
            }
            result.add(sum / currLevel.size());
        }
        return result;
    }
    
    public void traverse(TreeNode root, int level, List<List<Integer>> levels) {
        if(root == null) return;
        
        if(level > levels.size()) {
            levels.add(new LinkedList<>());
        }
        levels.get(level - 1).add(root.val);
        
        traverse(root.left, level + 1, levels);
        traverse(root.right, level + 1, levels);
    }
}