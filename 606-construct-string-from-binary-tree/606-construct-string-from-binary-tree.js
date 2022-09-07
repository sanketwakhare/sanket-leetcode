/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {string}
 */
var tree2str = function(root) {
    let res = [];
    preorder(root, res);
    res.pop();
    res.shift();
    return res.join("");
};

const preorder = (root, res) => {
    if(root === null) return;
    res.push("(");
    res.push(root.val);
    if(root.left === null && root.right !== null)
        res.push("()");    
    preorder(root.left, res);
    preorder(root.right, res);
    res.push(")");
}