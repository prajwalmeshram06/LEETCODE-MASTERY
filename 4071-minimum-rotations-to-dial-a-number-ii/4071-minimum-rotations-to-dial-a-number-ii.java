class Solution {
    int dist(char a, char b) {
        int distance = Math.abs(a - b);

        return Math.min(distance, 10 - distance);
    }
    
    public int minRotations(int n, String s) {
        int minRotation = 0;

        int total = 0;

        for(int i = 1; i < n; i++) {
            total += dist(s.charAt(i - 1), s.charAt(i)); 
        }


        int k0 = dist('0', s.charAt(n - 1)) + total;
        total = dist('0', s.charAt(0)) + total;

        minRotation = Math.min(k0, total);
        
        for(int i = 1; i < n; i++) {
            int old = dist(s.charAt(i - 1), s.charAt(i));
            int New = dist(s.charAt(i - 1), s.charAt(n - 1));

            int cost = total - old + New;

            minRotation = Math.min(minRotation, cost);
        }

        return minRotation;
    }
}