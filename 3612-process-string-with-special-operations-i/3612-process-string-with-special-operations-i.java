class Solution {
    public String processStr(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isLetter(ch)) {
                st.push(ch);
            }

            else if (ch == '*') {
                if (!st.isEmpty()) {
                    st.pop();
                }
            }

            else if (ch == '#') {
                int curr = st.size();

                for (int j = 0; j < curr; j++) {
                    st.push(st.get(j));
                }
            }

            else if (ch == '%') {
                int l = 0;
                int r = st.size() - 1;

                while (l < r) {
                    char temp = st.get(l);
                    st.set(l, st.get(r));
                    st.set(r, temp);

                    l++;
                    r--;
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        for (char ch : st) {
            ans.append(ch);
        }

        return ans.toString();
    }
}