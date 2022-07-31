class NumArray {

    SegmentTree root = null;
    public NumArray(int[] nums) {
        root = new SegmentTree(nums, 0, nums.length-1);
    }
    
    public void update(int index, int val) {
        root.update(index, val);
    }
    
    public int sumRange(int left, int right) {
        return root.sum(left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */

class SegmentTree {
    int val;
    SegmentTree left;
    SegmentTree right;
    int start;
    int end;

    public SegmentTree(int[] nums, int start, int end) {
        if (start == end) {
            this.val = nums[start];
            this.start = this.end = start;
        } else {
            int mid = start + (end - start) / 2;
            this.left = new SegmentTree(nums, start, mid);
            this.right = new SegmentTree(nums, mid + 1, end);
            this.val = this.left.val + this.right.val;
            this.start = Math.min(this.left.start, this.right.start);
            this.end = Math.max(this.left.end, this.right.end);
        }
    }

    public void update(int index, int val) {
        if (this.left == this.right) {
            this.val = val;
        } else {
            int mid = this.start + (this.end - this.start) / 2;
            if (index <= mid) {
                this.left.update(index, val);
            } else {
                this.right.update(index, val);
            }
            this.val = this.left.val + this.right.val;
        }
    }

    public int sum(int start, int end) {
        if (start > end) return 0;
        if (start == this.start && end == this.end) return this.val;
        int mid = this.start + (this.end - this.start) / 2;
        return this.left.sum(start, Math.min(mid, end)) + this.right.sum(Math.max(mid + 1, start), end);
    }
}