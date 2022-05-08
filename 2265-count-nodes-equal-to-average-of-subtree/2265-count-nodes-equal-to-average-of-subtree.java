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
    
    class Pair {
        int count;
        int sum;
        int nodeCount;
        public Pair(int count, int sum, int nodeCount) {
            this.count = count;
            this.sum = sum;
            this.nodeCount = nodeCount;
        }
    }
    
    public int averageOfSubtree(TreeNode root) {
        // post order traversal
        
        Pair temp = postOrder(root);
        return temp.count;
    }
    
    public Pair postOrder(TreeNode root) {
        
        if(root == null) {
            return new Pair(0, 0, 0);
        }
        
        Pair x = postOrder(root.left);
        Pair y = postOrder(root.right);
        
        int cnt = x.count + y.count;
        int sum = x.sum + y.sum + root.val;
        int nodeCount = x.nodeCount + y.nodeCount + 1;
        
        if((sum / nodeCount) == root.val) {
            cnt = cnt + 1;
        }
        return new Pair(cnt, sum, nodeCount);
    }
}