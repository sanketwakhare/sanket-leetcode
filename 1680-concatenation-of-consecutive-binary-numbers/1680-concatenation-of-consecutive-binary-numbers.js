/**
 * @param {number} n
 * @return {number}
 */
var concatenatedBinary = function(n) {
    
    let curr = 1;
    let stringRepresentation = "0";
    let num = 0;
    let p = 1000000007;
    
    while(curr <= n) {
        stringRepresentation = num.toString(2);
        stringRepresentation += curr.toString(2);
        num = parseInt(stringRepresentation, 2);
        num = (num) % p;
        curr++;
    }

    return num;
    
};