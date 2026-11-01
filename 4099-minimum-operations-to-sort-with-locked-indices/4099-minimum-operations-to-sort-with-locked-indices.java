class Solution {
    public int minOperations(int[] nums, int[] locked, int k) {
        int n = nums.length;

        int swaps = 0;
        int ops = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 1; j++) {
                if(nums[j] > nums[j + 1]) {
                    if(locked[j] == 1) {
                        locked[j] = 0;
                        ops++;
                    }
                    if(locked[j + 1] == 1) {
                        locked[j + 1] = 0;
                        ops++;
                    }
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swaps++;
                }
            }
        }

        if(ops > k) {
            return -1;
        }

        return ops + swaps;
    }
}