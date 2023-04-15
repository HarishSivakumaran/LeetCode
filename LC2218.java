// 2218. Maximum Value of K Coins From Piles

class Solution {

    HashMap<String, Integer> cache = new HashMap();

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        return getMax(piles, k, 0);
    }

    public int getMax(List<List<Integer>> piles, int k, int i) {
        if (k == 0 || i >= piles.size())
            return 0;

        String key = k + "-" + i;

        if (cache.containsKey(key))
            return cache.get(key);

        int max = 0, sum = 0;

        max = Math.max(max, getMax(piles, k, i + 1));

        for (int j = 0; j < Math.min(piles.get(i).size(), k); j++) {
            sum += piles.get(i).get(j);
            max = Math.max(max, sum + getMax(piles, k - (j + 1), i + 1));
        }

        cache.put(key, max);

        return max;
    }

}