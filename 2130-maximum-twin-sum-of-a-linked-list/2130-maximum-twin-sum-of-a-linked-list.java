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
    public int pairSum(ListNode head) {
        
        // find mid and break into 2 linked lists
        ListNode secondList = split(head);
        
        // reverse second half
        secondList = reverse(secondList);
        
        // perform sum
        ListNode temp1 = head;
        ListNode temp2 = secondList;
        int answer = 0;
        while(temp1 != null && temp2 != null) {
            int sum = temp1.val + temp2.val;
            answer = Math.max(sum, answer);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return answer;
    }
    
    public ListNode split(ListNode head) {
        if(head == null || head.next == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode newList = slow.next;
        slow.next = null;
        return newList;
    }
    
    public ListNode reverse(ListNode head) {
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