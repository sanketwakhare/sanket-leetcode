/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        int n = right - left + 1;
        ListNode dummyHead = new ListNode(-600);
        dummyHead.next = head;
        
        ListNode trav = dummyHead;
        while(trav != null && left-1 > 0) {
            trav = trav.next;
            left--;
        }
        trav.next = reverse(trav, n);
        return dummyHead.next;
    }
    
    public ListNode reverse(ListNode prevNode, int n) {
        
        ListNode oldHead = prevNode.next;
        ListNode prev = null;
        ListNode curr = prevNode.next;
        ListNode next = null;
        
        while(curr != null && n > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n--;
        }
        oldHead.next = curr;
        return prev;
    }
}