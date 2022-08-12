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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // find path from root to both p and q nodes
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        findPath(root, p, pPath);
        findPath(root, q, qPath);
        
        // initialize lca
        TreeNode lca = root;
        // reverse both paths
        Collections.reverse(pPath);
        Collections.reverse(qPath);
        // check nodes from both paths and identify the last common node
        for(int i=0; i< pPath.size() && i< qPath.size(); i++) {
            if(pPath.get(i) == qPath.get(i)) {
                lca = pPath.get(i);
            } else {
                break;
            }
        }
        return lca;
    }
    
    public boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if(root == null) return false;
        
        if(root == target) {
            path.add(root);
            return true;
        }
        
        boolean x = findPath(root.left, target, path);
        if(x) {
            path.add(root);
            return true;
        }
        boolean y = findPath(root.right, target, path);
        if(y) {
            path.add(root);
            return true;
        }
        return false;
    }
        
}