/**
 * @param {number[]} nums
 * @param {number[][]} queries
 * @return {number[]}
 */
var sumEvenAfterQueries = function(nums, queries) {
    // initial sum
    let sum = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] % 2 === 0) {
            sum += Number(nums[i])
        }
    }

    let result = [];
    for (let i = 0; i < queries.length; i++) {
        let val = Number(queries[i][0]);
        let index = Number(queries[i][1]);

        let newVal = nums[index] + val;
        let oldValue = nums[index];

        // if old value is even, subtract old value from sum
        if(oldValue % 2 === 0) {
            sum -= oldValue;
        }
        // update new sum
        nums[index] = newVal;

        // if new sum is even, add it to result
        if (newVal % 2 === 0) {
            sum += newVal;
        }
        result.push(sum);
    }
    return result;
};