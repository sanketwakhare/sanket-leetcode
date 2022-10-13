/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        
        ListNode temp = node;
        ListNode prev = node;
        while(temp.next != null) {
            int t = temp.next.val;
            temp.next.val = temp.val;
            temp.val = t;
            
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
    }
}