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
    public ListNode mergeKLists(ListNode[] lists) {
        
        // initialize minHeap
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                if(l1!=null && l2!=null) {
                    return l1.val - l2.val;
                }
                return 0;
            }
        });
        
        // insert all heads of all lists into heap
        for(int i=0; i< lists.length; i++) {
            ListNode currHead = lists[i];
            if(currHead != null) {
                minHeap.add(currHead);
            }
        }
        
        // now get the min element from heap and insert next element of min into heap is available
        ListNode head = null;
        ListNode curr = head;
        while(!minHeap.isEmpty()) {
            
            ListNode x = minHeap.poll();
            if(head == null) {
                // if head is null, update head
                head = x;
                curr = head;                
            } else {
                // add x to the last of curr pointer
                curr.next = x;
                curr = curr.next;                
            }
            // insert next element of x into heap if available
            ListNode temp = x.next;
            if(temp != null) {
                minHeap.add(temp);
            }
        }
        // return head of the merged list
        return head;
        
    }
}