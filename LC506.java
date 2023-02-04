// 506. Relative Ranks

class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] out = new String[score.length];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < score.length; i++) {
            pq.add(new int[] { score[i], i });
        }

        int place = 1;

        while (pq.size() > 0) {
            int[] curr = pq.poll();
            out[curr[1]] = getPos(place++);
        }

        return out;

    }

    public String getPos(int place) {
        switch (place) {
            case 1:
                return "Gold Medal";
            case 2:
                return "Silver Medal";
            case 3:
                return "Bronze Medal";
            default:
                return String.valueOf(place);
        }
    }
}