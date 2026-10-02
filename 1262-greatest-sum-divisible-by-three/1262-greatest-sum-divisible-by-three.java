class Solution {
    public int maxSumDivThree(int[] nums) {
        int total = 0;
        int rem1 = Integer.MAX_VALUE;
        int rem2 = Integer.MAX_VALUE;

        for(int num : nums) {
            total += num;

            if(num % 3 == 1) {
                if(rem1 != Integer.MAX_VALUE) {
                    rem2 = Math.min(rem2, num + rem1);
                }
                rem1 = Math.min(rem1, num);
            }

            if(num % 3 == 2) {
                if(rem2 != Integer.MAX_VALUE) {
                    rem1 = Math.min(rem1, rem2 + num);
                }
                rem2 = Math.min(rem2, num);
            }
        }

        if(total % 3 == 0) {
            return total;
        } else if(total % 3 == 1) {
            return total - rem1;
        } else {
            return total - rem2;
        }
    }
}