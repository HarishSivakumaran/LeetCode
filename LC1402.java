// 1402. Reducing Dishes

class Solution {
    int res = 0;
    HashMap<String, Integer> cache = new HashMap();

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        if (satisfaction[satisfaction.length - 1] < 0)
            return 0; // all negative

        if (satisfaction[0] >= 0) {
            for (int i = 1; i <= satisfaction.length; i++) {
                res += i * satisfaction[i - 1];
            }

            return res;
        }

        return permutation(satisfaction, 0, new ArrayList<Integer>());

    }

    public int permutation(int[] satisfaction, int i, List<Integer> list) {

        if (i >= satisfaction.length) {
            return 0;
        }

        String key = list.size() + "-" + i;

        if (cache.containsKey(key))
            return cache.get(key);

        int size = list.size();

        list.add(satisfaction[i]);

        int sumWith = 0, sumWithout = 0;

        sumWith += (list.size() * satisfaction[i]);

        sumWith += permutation(satisfaction, i + 1, list);

        list.remove((int) list.size() - 1);

        sumWithout = permutation(satisfaction, i + 1, list);

        cache.put(key, Math.max(sumWith, sumWithout));

        return cache.get(key);

    }
}