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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null) return head;
        
        int N = 1;
        ListNode temp = head;
        while(temp.next != null) {
            N++;
            temp = temp.next;
        }
        // point last to head
        temp.next = head;
        
        // traverse N-k elements and break the link
        k = k % N;
        int pos = N-k-1;
        temp = head;
        while( pos > 0) {
            temp = temp.next;
            pos--;
        }
        // save new head
        head = temp.next;
        // break the link
        temp.next = null;
        // return new head
        return head;
    }
}