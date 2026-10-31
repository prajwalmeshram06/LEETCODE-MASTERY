
import java.util.*;

class Solution {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) return ans;

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        set.remove(beginWord);

        Map<String, List<String>> parents = new HashMap<>();

        boolean found = false;

        while (!q.isEmpty() && !found) {

            int size = q.size();

            HashSet<String> nextLevel = new HashSet<>();

            while (size-- > 0) {

                String s = q.poll();
                char[] arr = s.toCharArray();

                for (int i = 0; i < arr.length; i++) {

                    char original = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        if (ch == original) continue;

                        arr[i] = ch;
                        String n = new String(arr);

                        if (set.contains(n)) {

                            parents.computeIfAbsent(n, k -> new ArrayList<>()).add(s);

                            nextLevel.add(n);

                            if (n.equals(endWord)) {
                                found = true;
                            }
                        }
                    }

                    arr[i] = original;
                }
            }

            set.removeAll(nextLevel);
            q.addAll(nextLevel);
        }

        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);

            dfs(endWord, beginWord, parents, path);
        }

        return ans;
    }

    public void dfs(String word, String beginWord,
                    Map<String, List<String>> parents,
                    List<String> path) {

        if (word.equals(beginWord)) {

            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);

            return;
        }

        if (!parents.containsKey(word)) return;

        for (String p : parents.get(word)) {

            path.add(p);

            dfs(p, beginWord, parents, path);

            path.remove(path.size() - 1);
        }
    }
}
