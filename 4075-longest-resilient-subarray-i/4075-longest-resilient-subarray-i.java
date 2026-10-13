class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int maxLen = 0;

        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            int currLen = 0;
            
            for(int j = i; j < nums.length; j++) {

                if(j > i && ((nums[j] - nums[j - 1]) % k != 0)) {
                    break;
                }
                sum += nums[j];

                if(((sum - nums[j]) % k) == 0) {
                    currLen = j - i + 1;
                    maxLen = Math.max(maxLen, currLen);
                }

                

                // boolean isValid = true;
                // for(int x = i; x <= j; x++) {
                //     if((sum - nums[x]) % k != 0) {
                //         isValid = false;
                //         break;
                //     }
                // }

                // if(isValid) {
                //     currLen = j - i + 1;

                //     maxLen = Math.max(maxLen, currLen);
                // }
            }
        }

        return maxLen;
    }
}