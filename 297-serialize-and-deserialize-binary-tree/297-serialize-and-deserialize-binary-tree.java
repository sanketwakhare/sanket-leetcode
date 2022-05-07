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
        
        if(root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            
            TreeNode temp = queue.poll();
            if(temp!= null) {
                TreeNode left = temp.left;
                TreeNode right = temp.right;
                queue.add(left);
                queue.add(right);
            }
            if(temp != null) {
                sb.append(temp.val +",");
            } else {
                sb.append(null +",");
            }
        }
        // remove last comma
        if(sb.length() > 0) {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if("".equals(data)) return null;
        String[] nodes = data.split(",");
        
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int i = 1;
        while(queue.size() != 0 && i < nodes.length-1) {
            TreeNode temp = queue.poll();
            // construct left node
            if(!nodes[i].equals("null")) {
                temp.left = new TreeNode(Integer.valueOf(nodes[i]));
                queue.add(temp.left);
            }
            // construct right node
            if(!nodes[i+1].equals("null")) {
                temp.right = new TreeNode(Integer.valueOf(nodes[i+1]));
                queue.add(temp.right);
            }
            i = i + 2;
        }
        return root;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));