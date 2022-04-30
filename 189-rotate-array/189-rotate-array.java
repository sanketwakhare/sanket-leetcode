class Solution {
    public void rotate(int[] nums, int k) {
        
        int N = nums.length;
        k = k % N;
        
        // reverse entire array
        reverse(nums, 0, N-1);
        // reverse first k elements
        reverse(nums, 0, k-1);
        // reverse N-k elements
        reverse(nums, k, N-1);        
    }
    
    // Reverse array elements from given range
    public void reverse(int[] A, int start, int end) {
        
        while(start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }
}