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
    
    int rightViewLevel = 0;
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> rightView = new ArrayList<>();
        traverse(root, 1, rightView);
        return rightView;
    }
    
    public void traverse(TreeNode root, int currLevel, List<Integer> rightView) {
        if(root == null) return;
        
        if(currLevel > rightViewLevel) {
            rightView.add(root.val);
            rightViewLevel++;
        }
        traverse(root.right, currLevel+1, rightView);
        traverse(root.left, currLevel+1, rightView);
    }
}


// 1, curLevel=1, rightViewLevel = 1
//     0<1
// 3, curLevel=2, rightViewLevel = 2
    
// 2, curLevel=2, rightViewLevel = 2
//     do not consider
// 5, curLevel=3, rightViewLevel = 2
    
// rightview = 1 3 5