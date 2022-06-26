/**
 * @param {number[]} cardPoints
 * @param {number} k
 * @return {number}
 */
var maxScore = function(cardPoints, k) {
    
    // sliding window approach
    
    let max = 0;
    
    for(let i=0; i<k; i++) {
        max += cardPoints[i];
    }
    
    let j = 0;
    let currPoints = max;
    for(let i=k-1; i>=0; i--) {
        
        let eleToRemove = cardPoints[i];
        let eleToAdd = cardPoints[cardPoints.length-1 - j++]
        
        currPoints += eleToAdd - eleToRemove;
        if(currPoints > max) {
            max = currPoints;
        }        
    }
    
    return max;
    
};