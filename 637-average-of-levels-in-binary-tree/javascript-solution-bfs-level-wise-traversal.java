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

class QueueNode {
    TreeNode node;
    int level;
    public QueueNode(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        // level wise traversal
        List<Double> result = new ArrayList<>();
        
        List<List<Integer>> levels = new ArrayList<>();
        Queue<QueueNode> queue = new LinkedList<>();
        queue.add(new QueueNode(root, 1));
        queue.add(null);
        
        while(queue.size() > 1) {
            QueueNode curr = queue.poll();
            if(curr == null) {
                queue.add(null);
            } else {
                TreeNode node = curr.node;
                int currLevel = curr.level;
                
                if(currLevel > levels.size()) {
                    levels.add(new ArrayList<Integer>());
                }
                levels.get(currLevel - 1).add(node.val);
                
                if(node.left != null) {
                    queue.add(new QueueNode(node.left, currLevel + 1));
                }
                if(node.right != null) {
                    queue.add(new QueueNode(node.right, currLevel + 1));
                }
            }
        }
        
        for(List<Integer> list : levels) {
            double sum = 0;
            for(int ele : list) {
                sum += ele;
            }
            result.add(sum / list.size());
        }
        
        return result;
    }
}
