/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        sb.append(root.val + ",");
        
        while(queue.size() > 1) {
            TreeNode curr = queue.poll();
            if(curr == null) {
                queue.add(null);
            } else {
                if(curr.left != null) {
                    sb.append(curr.left.val + ",");
                    queue.add(curr.left);
                } else {
                    sb.append(-1 + ",");
                }
                if(curr.right != null) {
                    sb.append(curr.right.val + ",");
                    queue.add(curr.right);
                } else {
                    sb.append(-1 + ",");
                }
            }
        }        
        sb.deleteCharAt(sb.length() - 1);
        String result = sb.toString();
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("".equals(data)) return null;
        
        String[] nodes = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        int rootValue = Integer.valueOf(nodes[0]);
        TreeNode root = new TreeNode(rootValue);
        queue.add(root);
        
        int index = 1;
        while(!queue.isEmpty() && index + 2 < nodes.length) {
            TreeNode curr = queue.poll();
            int leftValue = Integer.valueOf(nodes[index]);
            int rightValue = Integer.valueOf(nodes[index + 1]);
            if(leftValue != -1) {
                curr.left = new TreeNode(leftValue);
                queue.add(curr.left);
            }
            if(rightValue != -1) {
                curr.right = new TreeNode(rightValue);
                queue.add(curr.right);
            }
            index += 2;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;