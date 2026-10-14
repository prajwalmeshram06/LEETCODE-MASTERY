class Solution {
    static int[] countSort(int[] nums) {

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

    public int numRescueBoats(int[] people, int limit) {
        int[] arr = countSort(people);
        
        int left = 0;
        int right = arr.length - 1;
        int boats = 0;

        while (left <= right) {
            if (arr[left] + arr[right] <= limit) {
                left++;
            }

            right--;
            boats++;
        }

        return boats;

    }
}