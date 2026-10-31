import java.util.AbstractMap;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();

        for(String s : wordList) {
            set.add(s);
        }

        if(!set.contains(endWord)) return 0;

        Queue<Map.Entry<String, Integer>> q = new ArrayDeque<>();
        q.offer(new AbstractMap.SimpleEntry<>(beginWord, 1));

        while(!q.isEmpty()) {
            Map.Entry<String, Integer> curr = q.poll();

            String s = curr.getKey();
            int t = curr.getValue();
            StringBuilder sb = new StringBuilder(s);

            for(int i = 0; i < sb.length() && i <= 10; i++) {

                char original = sb.charAt(i);

                for(int j = 0; j < 26; j++) {

                    if(sb.charAt(i) == (char)(97 + j)) continue;
                    
                    sb.setCharAt(i, (char) (97 + j)); 
                    String n = sb.toString();

                    if(n.equals(endWord)) return t + 1;

                    if(set.contains(n)) {
                        q.offer(new AbstractMap.SimpleEntry<>(n, t + 1));
                        set.remove(n);
                    }
                }

                sb.setCharAt(i, original);
            }
        }
        return 0;  
    }
}