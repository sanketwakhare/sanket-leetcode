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
 * @param {number} k
 * @return {boolean}
 */
var findTarget = function(root, k) {
    
    let inOrder = [];
    traverse(root, inOrder);
    console.log(inOrder);

    let start = 0;
    let end = inOrder.length - 1;
    let sum = 0;
    while (start < end) {
        sum = inOrder[start] + inOrder[end];
        if (sum === k) {
            return true;
        } else if (sum > k) {
            end--;
        } else {
            start++;
        }
    }
    return false;
};

const traverse = (root, arr) => {
    if (root === null) return;
    traverse(root.left, arr);
    arr.push(root.val);
    traverse(root.right, arr);
}