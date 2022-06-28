/**
 * @param {string} s
 * @return {number}
 */
var minDeletions = function(s) {
    
    // build map
    let map = new Map();
    for(let i=0; i< s.length; i++) {
        let currChar = s.charAt(i);
        if(map.has(currChar)) {
            map.set(currChar, map.get(currChar) + 1);
        } else {
            map.set(currChar, 1);
        }
    }
    
    // build frequency array
    let freqArray = [];
    for(let value of map.values()) {
        freqArray.push(value);
    }
    // sort in descending order
    freqArray.sort((a,b) => b-a);
    
    
    let maxAllowed = freqArray[0]-1;
    let count = 0;
    for(let i=1; i< freqArray.length; i++) {
        if(freqArray[i] > maxAllowed) {
            // update count as we have to delete those many characters
            count += freqArray[i] - maxAllowed;
            // update maxAllowed
            maxAllowed = maxAllowed - 1;
        } else {
            // update maxAllowed to current freq - 1 as arrayis sorted in descending order
            maxAllowed = freqArray[i] - 1;
        }
        // make sure maxAllowed does not go less than 0
        maxAllowed = Math.max(0, maxAllowed);
    }
    return count;
    
};

// ceabaacb

// map1
// c => 2
// e => 1
// a => 3
// b => 2

// Map<Integer, List<Character>>
//     1 => e
//     2 => b
//     3 => c
//     4 => a
    
// 1+2