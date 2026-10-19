class Solution {
    public int[] countSort(int[] nums) {

        int [] ans = new int[nums.length];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        int[] count = new int[max - min + 1];

        for(int i = 0; i < nums.length; i++) {
            count[nums[i] - min]++;
        }

        for(int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
        }

        for(int i = nums.length - 1; i >= 0; i--) {
            int x = nums[i];
            count[x - min]--;
            int idx = count[x - min];
            ans[idx] = x;
        }

        return ans;
    }
    public List<Integer> targetIndices(int[] nums, int target) {
        nums = countSort(nums);

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if((nums[i] ^ target) == 0) {
                ans.add(i);
            }
        }

        return ans;
    }
}