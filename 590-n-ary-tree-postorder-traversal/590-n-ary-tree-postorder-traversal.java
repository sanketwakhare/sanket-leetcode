/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
    
    public void traverse(Node root, List<Integer> result) {
        if(root == null) return;        
        if(root.children != null) {
            for(Node child: root.children) {
                traverse(child, result);
            }
        }
        result.add(root.val);
    }
}