
var MinStack = function() {
    this.mainStack = [];
    this.min = -1;
};

/** 
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function(val) {
    if (this.mainStack.length === 0) {
        this.mainStack.push(val);
        this.min = val;
    } else {
        if (val < this.min) {
            // update min
            let newTop = (2 * val) - this.min;
            this.mainStack.push(newTop);
            this.min = val;
        } else {
            // do not update min
            this.mainStack.push(val);
        }
    }
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    // pop element from both stacks and return from mainStack
    if (this.mainStack.length > 0) {
        const poppedEle = this.mainStack.pop();
        if (poppedEle < this.min) {
            // update min
            let newMin = (this.min * 2) - poppedEle;
            this.min = newMin;
            return this.min;
        }
        return poppedEle;
    }
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    // return top
    if (this.mainStack.length === 0) return -1;
    if (this.mainStack[this.mainStack.length - 1] < this.min) {
        return this.min;
    }
    return this.mainStack[this.mainStack.length - 1];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    // return minimum
    if (this.mainStack.length === 0) return -1;
    return this.min;
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */