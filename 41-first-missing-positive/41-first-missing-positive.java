class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // convert -ves to 0
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        // mark corresponding index/bucket position -ve if positive element is present
        // in array
        for (int i = 0; i < n; i++) {
            if (Math.abs(nums[i]) > 0) {
                int val = Math.abs(nums[i]) - 1;
                if (val >= 0 && val < n) {
                    if (nums[val] == 0) {
                        // if element is 0 or negative
                        nums[val] = -1 * (n + 1);
                    } else if (nums[val] > 0) {
                        // if element is not already marked as -ve
                        nums[val] = nums[val] * -1;
                    }
                }
            }
        }

        // return first 0 or positive number or return n+1 in worst case if all positive
        // elements are present in array
        int answer = n + 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }
        return answer;
    }
}