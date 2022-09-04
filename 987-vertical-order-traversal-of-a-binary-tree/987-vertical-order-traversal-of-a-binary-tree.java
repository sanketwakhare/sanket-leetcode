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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        List<List<Integer>> result = new ArrayList<>();
        // traverse tree
        traverse(root, 0, 0, map);
        // prepare result list
        for(Map.Entry<Integer, Map<Integer, List<Integer>>> entry : map.entrySet()) {
            int key = entry.getKey();
            Map<Integer, List<Integer>> horizontallevels = entry.getValue();
            List<Integer> curr = new LinkedList<Integer>();
            for(Map.Entry<Integer, List<Integer>> hEntry : horizontallevels.entrySet()) {
                List<Integer> values = hEntry.getValue();
                Collections.sort(values);
                curr.addAll(values);
            }
            result.add(curr);
        }
        return result;
    }
    
    public void traverse(TreeNode root, int verticalLevel, int horizontallevel, Map<Integer, Map<Integer, List<Integer>>> map) {
        if(root == null) return;
        
        // update map
        Map<Integer, List<Integer>> horizontallevels = map.getOrDefault(verticalLevel, new TreeMap<>());
        List<Integer> overlappingNodes = horizontallevels.getOrDefault(horizontallevel, new ArrayList<>());
        overlappingNodes.add(root.val);
        horizontallevels.put(horizontallevel, overlappingNodes);
        map.put(verticalLevel, horizontallevels);
        
        // recursive calls to left and right subtree
        traverse(root.left, verticalLevel - 1, horizontallevel + 1, map);
        traverse(root.right, verticalLevel + 1, horizontallevel + 1, map);
    }
}