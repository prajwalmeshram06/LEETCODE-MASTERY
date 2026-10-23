class Solution {
    public int sortPermutation(int[] nums) {
        int and = 0;
        boolean one = true;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                if(one) {
                    and = i;
                    one = false;
                }

                and = and & nums[i]; 
            }
        }

        return and;
    }
}