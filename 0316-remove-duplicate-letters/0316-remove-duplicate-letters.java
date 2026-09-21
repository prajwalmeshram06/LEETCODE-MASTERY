class Solution {
    public String removeDuplicateLetters(String s) {

        int[] freq = new int[26];
        boolean[] used = new boolean[26];

        // Count remaining occurrences
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder num = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            int index = ch - 'a';

            // This occurrence is now being processed
            freq[index]--;

            // Already selected
            if (used[index]) {
                continue;
            }

            // Remove larger characters if they can appear again
            while (num.length() > 0 &&
                   num.charAt(num.length() - 1) > ch &&
                   freq[num.charAt(num.length() - 1) - 'a'] > 0) {

                char removed = num.charAt(num.length() - 1);

                used[removed - 'a'] = false;

                num.deleteCharAt(num.length() - 1);
            }

            num.append(ch);
            used[index] = true;
        }

        return num.toString();
    }
}