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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head;
        
        if(list1 == null && list2 == null ) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        if(list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        
        ListNode t1 = list1;
        ListNode t2 = list2;
        ListNode curr = head;
        while(t1 != null && t2 != null) {
            
            if(t1.val <= t2.val) {
                curr.next = t1;
                t1 = t1.next;
            } else {
                curr.next = t2;
                t2 = t2.next;
            }
            curr = curr.next;
        }
        
        if(t1 != null) {
            curr.next = t1;
        }
        if(t2 != null) {
            curr.next = t2;
        }
        
        return head;
        
        
    }
}