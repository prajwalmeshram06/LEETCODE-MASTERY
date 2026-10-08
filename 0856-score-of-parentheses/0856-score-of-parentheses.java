class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();

        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                st.push(0);
            else {
                int current = 0;
                while (st.peek() != 0) {
                    current += st.pop();
                }
                st.pop();
                if (current == 0) {
                    st.push(1);
                } else {
                    st.push(current * 2);

                }
            }
        }

        int ans = 0;
        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;

    }
}