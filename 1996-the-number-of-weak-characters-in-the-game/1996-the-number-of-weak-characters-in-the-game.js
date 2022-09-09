/**
 * @param {number[][]} properties
 * @return {number}
 */
var numberOfWeakCharacters = function(properties) {
    
    properties.sort((a, b) => {
        const attack1 = Number(a[0]);
        const defence1 = Number(a[1]);
        const attack2 = Number(b[0]);
        const defence2 = Number(b[1]);
        
        // sort in ascending order of attack and descending order of attack
        return attack1 - attack2 || defence2 - defence1;
    });
    
    let answer = 0;
    let prev = 0;
    for(let i=properties.length-1; i >= 0; i--) {
        const def = properties[i][1];
        if(def < prev) {
            answer++;
        } else {
            prev = def;
        }
    }
    return answer;
};