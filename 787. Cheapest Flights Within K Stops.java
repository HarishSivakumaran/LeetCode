class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(src == dst) return 0;

        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[src] = 0;

        for(int i = 0; i <= k; i++) {
            int[] mod = price.clone();
            boolean modb = false;
            for(int[] f : flights) {
                if(price[f[0]] != Integer.MAX_VALUE && price[f[0]]+f[2] < mod[f[1]]) {
                    mod[f[1]] = price[f[0]]+f[2];
                    modb = true;
                }
            }
            if(!modb) break;
            price = mod;
        }

        return price[dst] == Integer.MAX_VALUE ? -1 : price[dst];
    }
}