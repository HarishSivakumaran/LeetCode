class Solution {
    int mod = 1000000007;
    Long[][] cache = null;
    public int countVowelPermutation(int n) {
        cache = new Long[26][n];

        long ways = dfs('a', 1, n);
        ways %= mod;
        ways += dfs('e', 1, n);

        ways %= mod;
        ways += dfs('i', 1, n);

        ways %= mod;
        ways += dfs('o', 1, n);

        ways %= mod;
        ways += dfs('u', 1, n);
        ways %= mod;
        
        return (int) ways;
    }

    private long dfs(char curr, int index, int n) {
        if(index == n) return 1;
        if(cache[curr-'a'][index] != null) return cache[curr-'a'][index];
        char[] next = getNext(curr);
        long ways = 0;
        for(char nex : next) ways += dfs(nex, index+1, n);
        ways %= mod;
        return cache[curr-'a'][index] =   ways;
    }

    private char[] getNext(char a) {
        switch (a) {
            case 'a' : return new char[]{'e'};
            case 'e' : return new char[]{'a', 'i'};
            case 'i' : return new char[]{'a', 'e', 'o', 'u'};
            case 'o' : return new char[]{'i', 'u'};
            case 'u' : return new char[]{'a'};
        }

        return new char[]{'#'};
    }
}