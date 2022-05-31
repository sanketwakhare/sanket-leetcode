/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
    
    if(head == null || head.next == null) return head;
    
    let dummy = new ListNode('dummy');
    dummy.next = head;
    
    let prev = dummy;
    let first = head;
    let second = head.next;
    
    let isMatching = false;
    while(second!=null) {
        if(first.val == second.val) {
            first.next = second.next;
            second = second.next;
            isMatching = true;
        } else {
            if(isMatching) {
                first = second;
                second = second.next;
                prev.next = first;
                isMatching = false;
            } else {
                second = second.next;
                first = first.next;
                prev = prev.next;
            }
        }
    }
    if(isMatching) {
        prev.next = first.next;
    }
    return dummy.next;
};