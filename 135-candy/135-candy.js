/**
 * @param {number[]} ratings
 * @return {number}
 */
var candy = function(ratings) {
    
    let count = 0;
    let candies = new Array(ratings.length).fill(1);
    
    for(let i=1; i< ratings.length; i++) {
        if(ratings[i] > ratings[i-1]) {
            candies[i] += candies[i-1];
        }
    }
    
    for(let i=ratings.length-2; i>=0; i--) {
        if(ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) {
            candies[i] = candies[i+1]+1;
        }
    }
    
    for(let i=0; i<candies.length; i++) {
        count += candies[i];
    }
    return count;
};