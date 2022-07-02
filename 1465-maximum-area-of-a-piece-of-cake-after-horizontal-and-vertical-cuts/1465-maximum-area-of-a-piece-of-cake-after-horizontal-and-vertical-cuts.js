/**
 * @param {number} h
 * @param {number} w
 * @param {number[]} horizontalCuts
 * @param {number[]} verticalCuts
 * @return {number}
 */
var maxArea = function(h, w, horizontalCuts, verticalCuts) {
    
    horizontalCuts.sort((a, b) => Number(a) - Number(b));
    verticalCuts.sort((a, b) => Number(a) - Number(b));
    
    let maxHorizontalAdjDiff = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length -1]);
    let maxVerticalAdjDiff = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
    
    for(let i=0; i<horizontalCuts.length - 1; i++) {
        maxHorizontalAdjDiff = Math.max(maxHorizontalAdjDiff, horizontalCuts[i+1]- horizontalCuts[i]);
    }
        for(let i=0; i<verticalCuts.length - 1; i++) {
        maxVerticalAdjDiff = Math.max(maxVerticalAdjDiff, verticalCuts[i+1]- verticalCuts[i]);
    }
    
    return Number((BigInt(maxHorizontalAdjDiff) * BigInt(maxVerticalAdjDiff)) % BigInt(1000000007));
    
};
