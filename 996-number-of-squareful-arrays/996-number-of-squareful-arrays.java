class Solution {
    static int count = 0;
    public int numSquarefulPerms(int[] A) {
        count = 0;
        squarefulPermutations(0, A);
        return count;
    }
    public void squarefulPermutations(int i, int[] A) {
        
        // edge case for size=0
        if (A.length == 0) {
            count = 0;
        }
        // edge case when size of array is 1
        if (A.length == 1) {
            if (isSquare(A[0])) {
                count++;
            }
            return;
        }

        // base condition
        if (i == A.length) {
            count++;
        }

        // maintain a set to avoid repeated elements
        Set<Integer> set = new HashSet<Integer>();
        for (int k = i; k < A.length; k++) {
            if (!set.contains(A[k])) {
                // do swap
                swap(A, i, k);
                // if i==0, call recursive function
                if (i == 0) {
                    squarefulPermutations(i + 1, A);
                } else {
                    // if sum is perfect square, call recursive function
                    int sum = A[i] + A[i - 1];
                    if (isSquare(sum)) {
                        squarefulPermutations(i + 1, A);
                    }
                }
                // undo swap
                swap(A, i, k);
                // insert current element into set
                set.add(A[k]);
            }
        }
    }
    
    // util function
    public boolean isSquare(long sum) {
        double sqrt = Math.sqrt(sum);
        if (sqrt - Math.floor(sqrt) != 0) {
            return false;
        }
        return true;
    }

    // util function
    public void swap(int[] A, int i, int k) {
        int temp = A[i];
        A[i] = A[k];
        A[k] = temp;
    }
}