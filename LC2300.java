// 2300. Successful Pairs of Spells and Potions
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);

        int[] out = new int[spells.length];

        int s = spells.length - 1, p = 0, r = potions.length - 1;

        while (s >= 0) {
            p = 0;
            r = potions.length - 1;
            while (p <= r) {
                int m = p + (r - p) / 2;
                if ((long) spells[s] * potions[m] < success) {
                    p = m + 1;
                } else {
                    r = m - 1;
                }
            }
            out[s--] = potions.length - p;
        }

        return out;

    }

}