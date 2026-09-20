class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int ans = 0;
        Arrays.sort(boxTypes, (a,b) -> Integer.compare(b[1],a[1]));
        for(int i = 0; i < boxTypes.length; i++) {
            if(truckSize >= boxTypes[i][0]) {
                truckSize -= boxTypes[i][0];
                ans += boxTypes[i][0] * boxTypes[i][1];
            } else {
                ans += truckSize * boxTypes[i][1];
                return ans;
            }
        }
        return ans;
    }
}