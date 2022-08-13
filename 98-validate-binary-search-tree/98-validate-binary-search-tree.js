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
 * @return {boolean}
 */
var isValidBST = function(root) {
    
    const isValid = (root, min, max) => {
        if (root == null) return true;
        if (root.val >= min && root.val <= max) {
            let isLeftBST = isValid(root.left, min, root.val - 1);
            let isRightBST = isValid(root.right, root.val + 1, max);
            return isLeftBST && isRightBST;
        } 
        return false;
    }
    
    return isValid(root, Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER);
    
};

