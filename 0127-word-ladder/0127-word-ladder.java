class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord)) return 0;

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        set.remove(beginWord);

        int steps = 1;

        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                String s = q.poll();
                char[] arr = s.toCharArray();

                for(int i = 0; i < arr.length; i++) {
                    char original = arr[i];

                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        if(ch == original) continue;

                        arr[i] = ch;
                        String n = new String(arr);

                        if(n.equals(endWord)) return steps + 1;

                        if(set.remove(n)) {
                            q.offer(n);
                        }
                    }

                    arr[i] = original;
                }
            }

            steps++;
        }

        return 0;
    }
}