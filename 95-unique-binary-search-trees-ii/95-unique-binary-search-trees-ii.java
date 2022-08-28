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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return backtrack(1, n);
    }

    public List<TreeNode> backtrack(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftBSTs = backtrack(start, i - 1);
            List<TreeNode> rightBSTs = backtrack(i + 1, end);

            for (TreeNode left : leftBSTs) {
                for (TreeNode right : rightBSTs) {
                    TreeNode root = new TreeNode(i, left, right);
                    result.add(root);
                }
            }
        }
        return result;
    }
}