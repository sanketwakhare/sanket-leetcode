class Solution {
    public int lengthOfLIS(int[] nums) {
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (list.get(list.size() - 1) < nums[i]) {
                // if new elements is > last element from list, insert the new element
                list.add(nums[i]);
            } else {
                // find ceil of the current element and replace it with current element
                int ind = ceilOfK_binarySearch(list, 0, list.size() - 1, nums[i]);
                list.set(ind, nums[i]);
            }
        }
        return list.size();
    }
    
    public int ceilOfK_binarySearch(List<Integer> list, int start, int end, int k) {

        int ans = end;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (list.get(mid) == k) {
                return mid;
            } else if (list.get(mid) < k) {
                start = mid + 1;
            } else {
                ans = Math.min(ans, mid);
                end = mid - 1;
            }
        }
        return ans;
    }
}