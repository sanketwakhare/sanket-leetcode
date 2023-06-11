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
    class Pair {
        int index;
        int val;
        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    public int[] nextLargerNodes(ListNode head) {
        
        Stack<Pair> stack = new Stack<>();
        ListNode temp = head;
        int i = 0;
        while(temp != null) {         
            i++;
            temp = temp.next;
        }
        int[] result = new int[i];
        
        temp = head;
        i = 0;
        while(temp != null) {
            int curr = temp.val;
            while(!stack.isEmpty() && curr > stack.peek().val) {
                // found greater element
                result[stack.peek().index] = curr;
                // System.out.println("[" + stack.peek().index + "] " + stack.peek().val +" -> "+ curr);
                stack.pop();
            }
            stack.push(new Pair(i, curr));
            i++;
            temp = temp.next;
        }
        // while(!stack.isEmpty()) {
        //     System.out.println("[" + stack.peek().index + "] " + stack.peek().val +" -> "+ 0);
        //     stack.pop();
        // }
        return result;        
    }
}