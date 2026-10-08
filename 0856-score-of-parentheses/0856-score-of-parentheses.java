
class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0;
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                len++;
            } else {
                len--;

                if (s.charAt(i - 1) == '(') {
                    score += 1 << len;
                }
            }
        }

        return score;
    }
}