class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int current = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                current++;
            } else if(s.charAt(i) == ')') {
                current--;
            }
            ans = Math.max(ans, current);
        }

        return ans;
    }
}