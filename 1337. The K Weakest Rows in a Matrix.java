class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]> (
            (a, b) -> {
                // index, soldiers
                if(a[1]==b[1]) return b[0]-a[0];
                return b[1]-a[1];
            }
        );
        for(int r = 0; r < mat.length; r++) {
            int soldiers = 0;
            for(int c = 0; c < mat[0].length && mat[r][c] == 1; c++){
                soldiers++;
            }
            pq.add(new int[]{r, soldiers});
            if(pq.size()>k)pq.poll();
        }
        int[] out = new int[k];
        for(int i = k-1; i >= 0; i--) {
            out[i] = pq.poll()[0];
        }

        return out;
    }
}