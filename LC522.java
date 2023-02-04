// 522. Longest Uncommon Subsequence II

class Solution {
    public int findLUSlength(String[] strs) {
        int max = -1;

        Arrays.sort(strs, (a, b) -> b.length() - a.length());
        HashSet<String> hs = new HashSet();
        HashMap<String, LinkedHashSet<String>> freq = new HashMap();

        for (String s : strs) {
            if (hs.contains(s)) {
                freq.get("once").remove(s);
                freq.computeIfAbsent("mult", v -> new LinkedHashSet()).add(s);
            } else {
                hs.add(s);
                freq.computeIfAbsent("once", v -> new LinkedHashSet()).add(s);
            }
        }

        for (String possAns : freq.get("once")) {
            boolean isValid = true;
            if (freq.get("mult") != null)
                for (String notAns : freq.get("mult")) {
                    if (possAns.length() > notAns.length())
                        break;
                    isValid = !isSubSequence(notAns, possAns, 0, 0);
                    if (!isValid)
                        break;
                }
            if (isValid)
                return possAns.length();

        }

        return max;
    }

    public boolean isSubSequence(String from, String to, int i, int j) {
        if (j >= to.length())
            return true;

        if (i >= from.length())
            return false;

        if (from.charAt(i) == to.charAt(j)) {
            return isSubSequence(from, to, i + 1, j + 1);
        }

        return isSubSequence(from, to, i + 1, j);

        // for(int i = 0; i < to.length(); i++){ You TRIED warrior XP
        // int p1 = from.indexOf(to.charAt(i));
        // if(p1 == -1) return true;
        // if(i+1 >= to.length()) continue;
        // int p2 = from.indexOf(to.charAt(i+1), p1);
        // if(p1 == -1) return true;
        // if(p1 > p2) return true;
        // }
    }
}