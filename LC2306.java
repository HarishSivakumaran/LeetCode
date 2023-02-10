// 2306. Naming a Company

class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<String>[] set = new HashSet[26];

        for (String n : ideas) {
            if (set[n.charAt(0) - 'a'] == null) {
                set[n.charAt(0) - 'a'] = new HashSet();
            }
            set[n.charAt(0) - 'a'].add(n.substring(1));
        }

        long ans = 0;

        for (int i = 0; i < 25; i++) {
            if (set[i] == null)
                continue;
            for (int j = i + 1; j < 26; j++) {

                if (set[j] == null)
                    continue;
                int mutual = 0;

                for (String sub : set[i]) {
                    if (set[j].contains(sub))
                        mutual++;
                }

                ans += 2 * (set[i].size() - mutual) * (set[j].size() - mutual);
            }
        }

        return ans;
    }
}