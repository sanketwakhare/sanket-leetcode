/**
 * @param {string} s
 * @return {number}
 */
var minDeletions = function(s) {
    
    let map = new Map();
    for(let i=0; i< s.length; i++) {
        let currChar = s.charAt(i);
        if(map.has(currChar)) {
            map.set(currChar, map.get(currChar) + 1);
        } else {
            map.set(currChar, 1);
        }
    }
    
    let freqArray = [];
    for(let value of map.values()) {
        freqArray.push(value);
    }
    freqArray.sort((a,b) => b-a);
    console.log(freqArray);
    
    let maxAllowed = freqArray[0]-1;
    let count = 0;
    for(let i=1; i< freqArray.length; i++) {
        if(freqArray[i] > maxAllowed) {
            count += freqArray[i] - maxAllowed;
            maxAllowed = Math.max(0, maxAllowed - 1);
        } else {
            maxAllowed = Math.max(0, freqArray[i] - 1);
        }
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