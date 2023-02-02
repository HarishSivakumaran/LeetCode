// 447. Number of Boomerangs

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] p1 : points) {
            HashMap<Integer, Integer> hm = new HashMap();
            for (int[] p2 : points) {
                int dist = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
                hm.put(dist, hm.getOrDefault(dist, 0) + 1);
            }

            for (int v : hm.values()) {
                ans += v * (v - 1);
            }
        }
        return ans;

    }
}