/**
 * @param {number[]} nums
 * @return {number}
 */
var reversePairs = function(nums) {
    const answer = reversePair(nums, 0, nums.length - 1);
    return answer;
};


const merge = (A, l, m, r) => {

    // initialize pointers
    let p1 = l;
    let p2 = m;

    // initialize temp array
    let p3 = 0;
    let temp = new Array(r - l + 1).fill(0);

    // count based on condition separately
    let count = 0;
    while (p1 < m && p2 <= r) {
        if (A[p1] > (2 * A[p2])) {
            // if condition is met, increase the count by m-p1
            count = count + m - p1;
            // move p2 to next
            p2++;
        } else {
            // move p1 to next
            p1++;
        }
    }

    // merge elements separately
    p1 = l;
    p2 = m;
    while (p1 < m && p2 <= r) {
        if (A[p1] <= A[p2]) {
            temp[p3] = A[p1];
            p1++;
            p3++;
        } else {
            temp[p3] = A[p2];
            p2++;
            p3++;
        }
    }

    while (p1 < m) {
        temp[p3] = A[p1];
        p1++;
        p3++;
    }
    while (p2 <= r) {
        temp[p3] = A[p2];
        p2++;
        p3++;
    }

    for (let i = 0; i < r - l + 1; i++) {
        A[l + i] = temp[i];
    }

    return count;

}


const reversePair = (A, l, r) => {

    if (l === r) {
        return 0;
    }
    const mid = l + Math.floor((r - l) / 2);
    const x = reversePair(A, l, mid);
    const y = reversePair(A, mid + 1, r);

    const z = merge(A, l, mid + 1, r);

    return (x + y + z);
}

