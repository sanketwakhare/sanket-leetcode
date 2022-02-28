/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    
    let ans = new ListNode(-1);
    let temp = ans;
    let t1 = l1;
    let t2 = l2;
    
    let carry = 0;
    let sum = 0;
    while(t1!=null && t2!=null) {
        
        sum = t1.val + t2.val + carry;        
        
        carry = Math.floor(sum / 10);
        let nodeVal = sum % 10;
        
        let x = new ListNode(nodeVal);
        temp.next = x;            
        temp = temp.next;
        
        t1 = t1.next;
        t2 = t2.next;
        
    }
    
    while(t1!=null) {
        sum = t1.val + carry;
        carry = Math.floor(sum / 10);
        let nodeVal = sum % 10;
        
        let x = new ListNode(nodeVal);
        temp.next = x;            
        temp = temp.next;
        
        t1 = t1.next;        
    }
    
    while(t2!=null) {
        sum = t2.val + carry;
        carry = Math.floor(sum / 10);
        let nodeVal = sum % 10;
        
        let x = new ListNode(nodeVal);
        temp.next = x;            
        temp = temp.next;
        
        t2 = t2.next;        
    }
    
    if(carry > 0) {
        let x = new ListNode(carry);
        temp.next = x;
    }
    
    return ans.next;
    
};