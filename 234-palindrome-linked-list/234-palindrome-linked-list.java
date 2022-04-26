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
    public boolean isPalindrome(ListNode head) {
        
        // base case
        if(head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        
        ListNode head2 = null;
        
        while(fast.next != null) {        
            if(fast.next.next == null) {
                // even nodes
                head2 = slow.next;
                slow.next = null;                
                break;
            }
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            if(fast.next == null) {
                // odd nodes
                prev.next = null;
                head2 = slow.next;
                break;
            }
        }
        
        //reverse head2
        head2 = reverse(head2);
        
        // compare head and head2
        ListNode temp1 = head;
        ListNode temp2 = head2;
        boolean isPalindrome = true;
        while(temp1 != null && temp2 != null) {
            if(temp1.val != temp2.val) {
                isPalindrome = false;
                break;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return isPalindrome;
    }
    
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}