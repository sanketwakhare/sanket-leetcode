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

class QueueNode {
    Node node;
    int level;
    public QueueNode(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        
        Queue<QueueNode> queue = new LinkedList<>();
        queue.add(new QueueNode(root, 1));
        queue.add(null);
        
        while(queue.size() > 1) {
            QueueNode queueNode = queue.poll();
            if(queueNode == null) {
                queue.add(null);
            } else {
                Node node = queueNode.node;
                int level = queueNode.level;
                if(node != null) {
                    for(Node child : node.children) {
                        queue.add(new QueueNode(child, level + 1));
                    }
                    if(level > result.size()) {
                        result.add(new ArrayList<>());
                    }
                    result.get(level - 1).add(node.val);
                }
            }
        }
        
        return result;
    }
}