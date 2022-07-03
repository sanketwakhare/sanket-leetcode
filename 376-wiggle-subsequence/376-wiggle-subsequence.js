/**
 * @param {number[]} nums
 * @return {number}
 */
var wiggleMaxLength = function(nums) {
    
    if (nums.length === 1) return 1;
    
    let count = 1;
    let prevIndex = 0;
    let isPositive = undefined;
    for(let i=1; i< nums.length; i++) {
        let diff = nums[i] - nums[prevIndex];
        if(diff !== 0) {
            // inititlization of isPositive
            if(isPositive === undefined) {
                if(diff > 0) {
                    isPositive = true;
                } else {
                    isPositive = false;
                }
                count++;
                prevIndex = i;
                // console.log("init",count, prevIndex, i);
            } else {
                if(isPositive) {
                    // target for -ve diff
                    if(diff < 0) {
                        count++;
                        prevIndex = i;
                        isPositive = false;
                        // console.log("negative",count, prevIndex, i);
                    } else {
                          //max
                        if(nums[prevIndex] < nums[i]) {
                            prevIndex = i;
                        }
                    }
                } else {
                    // target for +ve diff
                    if(diff > 0) {
                        count++;
                        prevIndex = i;
                        isPositive = true;
                        // console.log("positive",count, prevIndex, i);
                    } else {
                        // min
                        if(nums[prevIndex] > nums[i]) {
                            prevIndex = i;
                        }
                    }
                }
            }
        }
    }
    return count;
};

// [1, 1, 1, 1, 7, 3, 8, 9, 5]

// 1, 7, 3, 8, 5