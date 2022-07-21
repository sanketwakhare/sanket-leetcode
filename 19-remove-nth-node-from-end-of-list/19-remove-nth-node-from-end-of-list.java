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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode trav = dummy;
        while(trav != null && n > 0) {
            trav = trav.next;
            n--;
        }
        
        ListNode slow = dummy;
        while(trav.next != null) {
            trav = trav.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}