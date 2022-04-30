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
        // return N-k+1st element as new head
        k = k % N;
        int pos = N-k;
        temp = head;
        while( pos > 1) {
            temp = temp.next;
            pos--;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}