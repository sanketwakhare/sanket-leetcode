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
        
        Set<Integer> elements = new TreeSet<Integer>();
        preOrder(root, elements);
        int[] arr = elements.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        int max = arr[0];
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                break;
            }
        }
        return max == arr[0] ? -1: max;
    }
    
    public void preOrder(TreeNode root, Set<Integer> elements) {
        if(root == null) return;
        
        elements.add(root.val);
        preOrder(root.left, elements);
        preOrder(root.right, elements);
    }
}