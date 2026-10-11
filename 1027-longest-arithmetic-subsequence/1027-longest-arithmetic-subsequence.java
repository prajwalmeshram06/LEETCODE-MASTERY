class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;

        if(n <= 2) {
            return n;
        }

        List<HashMap<Integer, Integer>> diff = new ArrayList<>();
        int max = 2;

        for(int i = 0; i < n; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for(int j = 0; j < i; j++) {

                int d = nums[i] - nums[j];
                int len = diff.get(j).getOrDefault(d, 1) + 1;
                map.put(d, Math.max(map.getOrDefault(d, 0), len));

                max = Math.max(max, map.get(d));
            }

            diff.add(map);
        }

        return max;
    }
}