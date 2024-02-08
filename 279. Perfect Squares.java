class Solution {
    static HashMap<Integer, Integer> map = new HashMap();

    public int numSquares(int n) {
        return getMin(n);
    }

    private int getMin(int n) {
        if(map.containsKey(n)) return map.get(n);
        if(n <= 3) return n;
        int i = 1, ans = 999999;
        while((i*i) <= n) {
            ans = Math.min(ans, 1+getMin(n-(i*i)));
            i++;
        }

        map.put(n, ans);

        return ans;
    }
}