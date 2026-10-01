class Solution {
    public long maxAlternatingSum(int[] nums) {

        int n = nums.length;
        long ans = 0;

        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));

        for(int i = 0; i < n / 2; i++) {
            ans -= (long) arr[i] * arr[i];
        }

        for(int j = n / 2; j < n; j++) {
            ans += (long) arr[j] * arr[j];
        }

        return ans;
    }
}