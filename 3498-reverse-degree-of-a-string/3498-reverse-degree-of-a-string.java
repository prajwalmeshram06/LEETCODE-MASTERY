class Solution {
    public int reverseDegree(String s) {
        int rDegree = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            map.put(ch, 'z' - ch + 1);
        }

        for(int i = 0; i < s.length(); i++) {
            int code = map.get(s.charAt(i));
            int product = (i + 1) * code;
            rDegree += product;
        }

        return rDegree;
    }
}