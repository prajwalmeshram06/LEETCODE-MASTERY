class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {

        Arrays.sort(tokens);

        int score = 0;

        int l = 0;
        int r = tokens.length - 1;

        while(l <= r) {

            int token = tokens[l];

            if(token <= power) {
                
                power -= token;
                score++;
                l++;
            } 
            else if(score > 0 && l < r) {

                int maxToken = tokens[r];
                
                power += maxToken;
                score--;
                r--;
            }
            else {
                break;
            }
            
        }

        return score;
    }
}