// 839. Similar String Groups

class Solution {
    public int numSimilarGroups(String[] strs) {

        int groups = strs.length;
        int[] parent = new int[strs.length];
        int[] rank = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (checkForMatch(strs[i], strs[j])) {
                    int p1 = findRoot(parent, i);
                    int p2 = findRoot(parent, j);
                    if (p1 == p2)
                        continue;
                    groups--;
                    if (rank[p1] > rank[p2]) {
                        rank[p1] += rank[p2];
                        parent[p2] = p1;
                    } else {
                        rank[p2] += rank[p1];
                        parent[p1] = p2;
                    }
                }
            }
        }

        return groups;

    }

    public int findRoot(int[] p, int i) {
        while (p[i] != i) {
            p[i] = p[p[i]];
            i = p[i];
        }

        return i;
    }

    public boolean checkForMatch(String s1, String s2) {
        int l = 0, diff = 0;
        String buffer = "";

        for (; l < s1.length(); l++) {
            if (s1.charAt(l) == s2.charAt(l))
                continue;
            if (diff == 0) {
                diff++;
                buffer = s1.charAt(l) + "-" + s2.charAt(l);
            } else if (diff > 0) {
                if (buffer.length() > 0) {
                    if (buffer.equals(s2.charAt(l) + "-" + s1.charAt(l))) {
                        buffer = "";
                        continue;
                    }
                }
                return false;
            }
        }

        return true;
    }
}