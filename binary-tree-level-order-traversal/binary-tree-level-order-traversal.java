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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        
        if(root == null) return levels;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        
        List<Integer> currLevel = new ArrayList<Integer>();
        
        while(queue.size() > 1) {
            
            TreeNode x = queue.poll();
            
            if(x == null) {
                // end of current level
                queue.add(null);
                
                levels.add(currLevel);
                currLevel = new ArrayList<Integer>();
            } else {
                //add element to current level
                currLevel.add(x.val);
                
                if(x.left != null) {
                    queue.add(x.left);
                }
                if(x.right != null) {
                    queue.add(x.right);
                }                
            }
        }
        levels.add(currLevel);
        return levels;                
    }
}