/**
 * @param {number[][]} people
 * @return {number[][]}
 */
var reconstructQueue = function(people) {
    
    people.sort((a,b) => a[0] === b[0] ? a[1] - b[1]: b[0] - a[0]);
    
    let result = [];
    for (const [height, k] of people) {
        result.splice(k, 0, [height, k]);
    }
    return result;
};

// Brute Force
// step1: sort based on position -> and then height -> nlogn
// step2: iterrate every element and check if is at correct position -> n^2
    // if not place it at correct position and restart from last correct position+1 

// A = [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]


// sorted = [[5,0],[7,0],[6,1],[7,1],[5,2],[4,4]]


// [[5,0],1,[5,2],3,[4,4],5]
// minHeap




// [7,0]
// [7,1]