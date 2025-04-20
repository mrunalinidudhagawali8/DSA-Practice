class NumArray {


//    Same as range sum immutable LC303
    
    int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public void update(int index, int val) {
        int num = prefixSum[index + 1] - prefixSum[index];
        int diff = val - num;
        if (prefixSum.length == 2 && index == 0) {
            prefixSum[1] = val;
            return;
        }
        for (int i = index + 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i] + diff;
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */