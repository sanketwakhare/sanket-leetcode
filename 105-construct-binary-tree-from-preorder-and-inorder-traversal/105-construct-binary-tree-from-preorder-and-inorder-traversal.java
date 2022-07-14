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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return construct(0, preorder.length-1,
                        0, inorder.length-1,
                        preorder,
                        inorder,
                        map);
    }
    
    public TreeNode construct(int preStart, int preEnd, 
                              int inStart, int inEnd, 
                              int[] preorder, 
                              int[] inorder, 
                              Map<Integer, Integer> map) {
        
        // base condition
        if(inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = map.get(preorder[preStart]);
        
        int leftSubtreeElementsCount = index - inStart;
        int rightSubtreeElementsCount = inEnd - index;
        
        root.left = construct(preStart+1, preStart+leftSubtreeElementsCount,
                             inStart, index - 1,
                             preorder,
                             inorder,
                             map);
        root.right = construct(preStart+leftSubtreeElementsCount+1, preEnd,
                             index + 1, inEnd,
                             preorder,
                             inorder,
                             map);
        return root;
        
    }
}