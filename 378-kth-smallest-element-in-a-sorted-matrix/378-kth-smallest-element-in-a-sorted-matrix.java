class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int answer = -1;
		MinHeap<Pair> minHeap = new MinHeap<Pair>();
		int rowsCount = matrix.length;
		int colsCount = matrix[0].length;

		// maintain the heap of size K = no of rows
		int i = 0;
		while (i < rowsCount) {
			Pair pair = new Pair(matrix[i][0], i, 0);
			i++;
			minHeap.insert(pair);
		}
		// extract minimum B-1 times
		while (k > 1) {
			// find min and insert the next element from same array
			Pair currMin = minHeap.getMinimum();
			if (currMin.j == colsCount - 1) {
				// no more elements to from current row/sorted array
			} else {
				Pair nextEleInSameRow = new Pair(matrix[currMin.i][currMin.j + 1], currMin.i, currMin.j + 1);
				minHeap.insert(nextEleInSameRow);
			}
			k--;
		}
		// extract last element from heap which is Bth smallest
		Pair kthMin = minHeap.getMinimum();
		answer = kthMin.key;
		return answer;
        
    }
    
    class Pair implements Comparable<Pair> {
		int key;
		int i;
		int j;

		public Pair(int key, int i, int j) {
			this.key = key;
			this.i = i;
			this.j = j;
		}

		@Override
		public int compareTo(Pair o2) {
			if (this.key > o2.key)
				return 1;
			else if (this.key < o2.key)
				return -1;
			return 0;
		}
	}
    
    class MinHeap<T extends Comparable<T>> {
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