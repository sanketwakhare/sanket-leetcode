/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if(head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                isCycle = true;
                break;
                //cycle found
            }
        }
        
        if(!isCycle) return null;
        
        ListNode curr = head;
        while(curr != slow) {
            curr = curr.next;
            slow = slow.next;
        }
        return slow;
    }
}