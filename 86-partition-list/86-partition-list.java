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
    public ListNode partition(ListNode head, int x) {
        
        ListNode head1 = new ListNode(Integer.MIN_VALUE);
        ListNode head2 = new ListNode(Integer.MIN_VALUE);
    
        ListNode trav1 = head1;
        ListNode trav2 = head2;
        
        ListNode temp = head;
        while(temp != null) {
            
            if(temp.val < x) {
                trav1.next = temp;
                trav1 = trav1.next;
            } else {
                trav2.next = temp;
                trav2 = trav2.next;
            }
            temp = temp.next;
            trav1.next = null;
            trav2.next = null;
        }
        trav1.next = head2.next;
        return head1.next;
        
    }
    
    
}