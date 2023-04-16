// 1639. Number of Ways to Form a Target String Given a Dictionary

class Solution {
    int[][] charCount = null;
    HashMap<String, Long> cache = new HashMap();

    public int numWays(String[] words, String target) {
        charCount = new int[words[0].length()][26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                charCount[i][word.charAt(i) - 'a']++;
            }
        }
        return (int) getWaysToTarget(words, target, 0, 0);
    }

    public long getWaysToTarget(String[] words, String target, int index, int tarIndex) {
        if (words[0].length() - index < target.length() - tarIndex)
            return 0;

        if (tarIndex >= target.length()) {
            return 1;
        }

        if (index >= words[0].length())
            return 0;

        String key = index + "-" + tarIndex;

        if (cache.containsKey(key))
            return cache.get(key);

        long ways = 0;
        ways += getWaysToTarget(words, target, index + 1, tarIndex);
        ways += (charCount[index][target.charAt(tarIndex) - 'a']
                * getWaysToTarget(words, target, index + 1, tarIndex + 1));
        ways %= (Math.pow(10, 9) + 7);

        cache.put(key, ways);

        return ways;
    }
}