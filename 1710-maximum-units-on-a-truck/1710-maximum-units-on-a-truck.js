/**
 * @param {number[][]} boxTypes
 * @param {number} truckSize
 * @return {number}
 */
var maximumUnits = function(boxTypes, truckSize) {
    boxTypes.sort((a, b) => {
       return Number(b[1]) - Number(a[1]);
    });
    
    let units = 0;
    let  i =0;
    while(truckSize > 0 && i < boxTypes.length) {
        
        if(truckSize >= boxTypes[i][0]) {
            units += boxTypes[i][0] * boxTypes[i][1];
            truckSize -= boxTypes[i][0];
        } else {
            // partial
            units += truckSize * boxTypes[i][1];
            truckSize = 0;
        }
        i++;
    }
    return units;
};

//  [[5,10],[3,9],[4,7],[2,5]]

// 10 -5 = 5- 3 = 2 - 2 =0
// 50 + 27 +14 = 91