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
class BSTIterator {

    private Stack<TreeNode> nodeStack;
    private Queue<Integer> queue;
    public BSTIterator(TreeNode root) {
        nodeStack = new Stack<>();
        queue = new LinkedList<>();
        TreeNode curr = root;
        while(!nodeStack.isEmpty() || curr!=null) {
            while(curr != null) {
                nodeStack.push(curr);
                curr = curr.left;
            }
            TreeNode top = nodeStack.pop();
            queue.add(top.val);
            curr = top.right;
        }
    }
    
    public int next() {
        if(hasNext()) {
            return queue.poll();
        }
        return -1;
    }
    
    public boolean hasNext() {
        if(queue.isEmpty()) return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */