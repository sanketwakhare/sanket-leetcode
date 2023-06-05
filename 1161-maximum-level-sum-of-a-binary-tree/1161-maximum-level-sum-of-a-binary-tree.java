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
    public int maxLevelSum(TreeNode root) {
        
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        List<List<Integer>> list = new LinkedList<>();

        int level = 1;
        while (q.size() > 1) {
            TreeNode curr = q.poll();

            if (curr == null) {
                level++;
                q.add(null);
                continue;
            }

            if (list.size() < level) {
                List<Integer> currLevel = new LinkedList<>();
                list.add(currLevel);
            }
            list.get(level - 1).add(curr.val);

            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int maxSumLevel = 1;
        for (int i = 0; i < list.size(); i++) {
            List<Integer> currList = list.get(i);
            int currSum = 0;
            for (int curr : currList) {
                currSum += curr;
            }
            if (currSum > maxSum) {
                maxSum = currSum;
                maxSumLevel = i + 1;
            }
        }

        return maxSumLevel;
    }
}