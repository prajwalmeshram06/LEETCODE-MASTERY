class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;

        if(n == 0) {
            return 0;
        }
        int[] diff = new int[n + 1];
        for(int i = 1; i < n; i++) {
            diff[i] = nums[i - 1] - nums[i];
        }

        int maxLen = 1;
        boolean turn = true;
        boolean first = true;

        

        for(int i = 1; i < n; i++) {
            if(diff[i] == 0) continue;

            if(first) {
                turn = diff[i] < 0;
                first = false;
                maxLen++;
                continue;
            }

            if(turn && diff[i] > 0) {
                maxLen++;
                turn = false;
            } else if(!turn && diff[i] < 0) {
                maxLen++;
                turn = true;
            }
        }
                

        return maxLen;
    }
}