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
import java.util.stream.*;

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        
        // create tree set - sorted set
        Set<Integer> elements = new TreeSet<Integer>();
        // perofrm preorder traversal
        preOrder(root, elements);
        
        // convert set to array
        int[] arr = elements.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        // find second max value from array
        int max = arr[0];
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                break;
            }
        }
        // second max is same as first max, return -1 else second max
        return max == arr[0] ? -1: max;
    }
    
    public void preOrder(TreeNode root, Set<Integer> elements) {
        if(root == null) return;
        
        elements.add(root.val);
        preOrder(root.left, elements);
        preOrder(root.right, elements);
    }
}