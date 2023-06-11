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
        int n = 0;
        ListNode temp = head;
        while(temp != null) {
            n++;
            temp = temp.next;
        }
        if(head == null) return head;
        if(k == 0) return head;
        if(k == n) return head;
        k = n - (k % n);
        
        ListNode prev = null;
        ListNode curr = null;
        int i = 0;
        temp = head;
        while(temp != null && i < k) {
            prev = curr;
            curr = temp;
            i++;
            temp= temp.next;
        }
        
        temp = curr;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        head = curr.next;
        curr.next = null;
        return head;
    }
}