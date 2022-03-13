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
        
        // Min Heap of size K where (K = size of list)
        MinHeap<NodeItem> minHeap = new MinHeap<NodeItem>();

        // store heads of all lists into heap
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if(node != null)
                minHeap.insert(new NodeItem(node.val, node));
        }

        // initialize head and temp pointers
        ListNode head = null;
        ListNode temp = head;

        // get min element from heap and append to next of result linked list
        while (!minHeap.isEmpty()) {
            // get minimum node from heap
            ListNode x = minHeap.getMinimum().node;
            
            // add next available node of the current minimum node into the heap
            ListNode nextNode = x.next;
            if (nextNode != null) {
                minHeap.insert(new NodeItem(nextNode.val, nextNode));
            }

            // attach the node x at end to the result list
            if (head == null) {
                head = x;
                temp = head;
            } else {
                temp.next = x;
                temp = temp.next;
            }
        }
        return head;  
    }
    
    // custom node type which stores value and linked list node
    class NodeItem implements Comparable<NodeItem> {
        int value;
        ListNode node;

        public NodeItem(int value, ListNode node) {
            this.value = value;
            this.node = node;
        }

        @Override
        public int compareTo(NodeItem o) {
            return this.value - o.value;
        }
    }
    
    // Min Heap implementation
    public class MinHeap<T extends Comparable<T>> {
        List<T> heap;

        public MinHeap() {
            heap = new ArrayList<T>();
        }

        public int size() {
            return heap.size();
        }

        public List<T> getHeap() {
            return heap;
        }

        public boolean isEmpty() {
            if (heap.size() == 0) {
                return true;
            }
            return false;
        }

        public void insert(T x) {

            heap.add(x);
            int i = this.heap.size() - 1;
            while (i > 0) {
                int parentIndex = (i - 1) / 2;
                if (heap.get(i).compareTo(heap.get(parentIndex)) < 0) {
                    swap(i, parentIndex);
                    i = parentIndex;
                } else {
                    return;
                }
            }
        }

        public T getMinimum() {
            T x = null;
            if (!isEmpty()) {
                x = heap.get(0);
                // swap last element and x
                swap(0, heap.size() - 1);
                heap.remove(heap.size() - 1);

                int i = 0;
                while ((2 * i) + 1 < heap.size()) {
                    int leftChildIndex = (2 * i) + 1;
                    int rightChildIndex = (2 * i) + 2;
                    T min = null;

                    // find minimum out of 3
                    min = heap.get(i).compareTo(heap.get(leftChildIndex)) < 0 ? heap.get(i) : heap.get(leftChildIndex);
                    if (rightChildIndex < heap.size()) {
                        min = heap.get(rightChildIndex).compareTo(min) < 0 ? heap.get(rightChildIndex) : min;
                    }

                    if (min == heap.get(i)) {
                        break;
                    } else if (min == heap.get(leftChildIndex)) {
                        swap(i, leftChildIndex);
                        i = leftChildIndex;
                    } else if (rightChildIndex < heap.size() && min == heap.get(rightChildIndex)) {
                        swap(i, rightChildIndex);
                        i = rightChildIndex;
                    }
                }

            }
            return x;
        }

        public T peekMin() {
            return heap.get(0);
        }

        private void swap(int i, int j) {
            T temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }
}