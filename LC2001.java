// 2001. Number of Pairs of Interchangeable Rectangles

class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Long> map = new HashMap();
        long ans = 0;
        double ratio = 0;

        for (int[] r : rectangles) {
            ratio = (double) r[0] / r[1];
            map.put(ratio, map.getOrDefault(ratio, 0l) + 1);
        }

        for (Map.Entry<Double, Long> entry : map.entrySet()) {
            ans += ((entry.getValue() * (entry.getValue() - 1)) / 2);
        }

        return ans;

    }
}