class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = 100000000;

        for(int i = 1; i < arr.length; i++)  {
            minDiff = Math.min(minDiff ,arr[i] - arr[i - 1]);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - arr[i - 1] == minDiff) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i - 1]);
                list.add(arr[i]);
                ans.add(list);
            }
        }

        return ans;
    }
}