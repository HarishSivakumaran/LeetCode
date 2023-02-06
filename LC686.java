// 686. Repeated String Match
class Solution {
    public int repeatedStringMatch(String a, String b) {
        int max = (b.length() / a.length()) + 2;
        StringBuilder c = new StringBuilder(a);

        for (int i = 1; i <= max; i++) {
            if (c.indexOf(b) != -1)
                return i;
            c.append(a);
        }

        return -1;

    }
}