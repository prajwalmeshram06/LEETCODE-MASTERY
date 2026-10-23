class Solution {
    public boolean canReach(int[] arr, int i) {
        int n = arr.length;
        if(arr[i] == 0) return true;
        if(arr[i] == -1) return false;

        int x = arr[i];
        arr[i] = -1;

        if(i + x < n && canReach(arr, i + x)) return true;
        if(i - x >= 0 && canReach(arr, i - x)) return true;

        return false;
    }
}