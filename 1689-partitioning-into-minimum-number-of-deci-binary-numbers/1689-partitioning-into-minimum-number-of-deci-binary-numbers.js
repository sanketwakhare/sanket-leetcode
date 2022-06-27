/**
 * @param {string} n
 * @return {number}
 */
var minPartitions = function(n) {
    
    let max = 0;
    for(let i=0; i< n.length; i++) {
        max = Math.max(Number(n.charAt(i)), max);
    }
    return max;
    
};