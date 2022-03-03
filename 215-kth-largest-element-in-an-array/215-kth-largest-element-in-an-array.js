/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function(nums, k) {
    
    nums.sort( (a,b) => {
        return Number(a) - Number(b);
    });
    return nums[nums.length-k];
    
};