class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int count = 0;

        for (List<Integer> indices : map.values()) {
            if (indices.size() < 3) {
                continue;
            }

            int diff = indices.get(1) - indices.get(0);
            boolean valid = true;

            for (int i = 2; i < indices.size(); i++) {
                if (indices.get(i) - indices.get(i - 1) != diff) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                count++;
            }
        }

        return count;
    }
}