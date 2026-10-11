class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if(n < 3) {
            return 0;
        }

        int[] iDp = new int[n + 1];
        Arrays.fill(iDp, 1);
        int[] dDp = new int[n + 1];
        Arrays.fill(dDp, 1);

        for(int i = 1; i < n; i++) {
            if(arr[i - 1] < arr[i]) {
                iDp[i] = iDp[i - 1] + 1;
            } 
        }

        for(int i = n - 2; i >= 0; i--) {
            if(arr[i] > arr[i + 1]) {
                dDp[i] = dDp[i + 1] + 1;
            }
        }

        int maxMountain = 0;

        for(int i = 0; i < n; i++) {
            if(iDp[i] > 1 && dDp[i] > 1) {
                maxMountain = Math.max(maxMountain, iDp[i] + dDp[i] - 1);
            }
        }

        return maxMountain;
    }
}