class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] freq = new int[10001];

        for(int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        } 

        int choice1 = freq[0] * 0;
        int choice2 = Math.max(freq[0] * 0, freq[1] * 1);

        for(int i = 2; i < freq.length; i++) {
            int curr = choice2;

            choice2 = Math.max(choice2,((freq[i] * i) + choice1));
            choice1 = curr;
            
        }

        return choice2;
    }
}