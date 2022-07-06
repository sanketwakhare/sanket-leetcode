/**
 * @param {number} n
 * @return {number}
 */
var fib = function(n) {
    
    if(n <= 1) return n;
    let prev2 = 0;
    let prev1 = 1;
    let curr;
    for(let i=2; i<=n;i++) {
        curr = prev1 + prev2;
        prev2 = prev1;
        prev1 = curr;
    }
    return curr;
    
};