/**
 * @param {number[]} nums
 * @return {number}
 */
var minMoves2 = function(nums) {
   
    nums.sort((a,b) => Number(a)- Number(b));
    
    let n = nums.length;
    let mid = Math.floor(n / 2);
    
    
    let count = 0;
    for(let ele of nums) {
        count += Math.abs(ele - nums[mid]);
    }
    return count;
    
};

// A = 5 3 7 2 1
// A = 2 3 1 5 7

// sorted = 1 2 3 5 7