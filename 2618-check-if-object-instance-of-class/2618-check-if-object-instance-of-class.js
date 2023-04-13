/**
 * @param {Object} object
 * @param {Function} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    // return obj instanceof classFunction;
    // constructor
    while(obj!= null) {
        if(obj?.constructor === classFunction) {
            return true;
        }
        obj = Object.getPrototypeOf(obj);
    }
    return false;
};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */