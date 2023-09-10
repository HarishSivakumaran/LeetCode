class Solution {
    // HashMap<String, Integer> cache = new HashMap();
    Integer[][] cache = null;
    public int minimumMoves(int[][] grid) {
        List<int[]> zeroes = new ArrayList();
        List<int[]> greats = new ArrayList();
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 0) {
                    zeroes.add(new int[]{r, c});
                }

                 if(grid[r][c] > 1) {
                    greats.add(new int[]{r, c});
                }
            }
        }

        cache = new Integer[(1<<zeroes.size())][greats.size()];

        return getMin(zeroes, greats, 0, 0, grid);
    }

    private int getMin(List<int[]> zeroes, List<int[]> greats,
    int index, int state, int[][] grid) {
        if(state == (1<<zeroes.size())-1) return 0;
        if(index >= greats.size()) return 9999;

        if(cache[state][index] != null) return cache[state][index];

        int[] curr = greats.get(index);
        int excess = grid[curr[0]][curr[1]]-1;
        List<List<Integer>> chosen = new ArrayList();

        int min = Integer.MAX_VALUE;

        getComb(excess, new ArrayList(), chosen, state, 0, zeroes.size());

        for(List<Integer> choose : chosen) {
            int val = 0;
            int newState = state;
            for(int z : choose) {
                int[] zero = zeroes.get(z);
                val += Math.abs(zero[0]-curr[0]) + Math.abs(zero[1]-curr[1]);
                newState |= (1 << z);
            }
            min = Math.min(min, val + getMin(zeroes, greats,
             index+1, newState, grid));
        }
        return cache[state][index] = min;
    }

    private void getComb(int need, List<Integer> curr,
     List<List<Integer>> chosen, int state, 
     int index, int n) {
         if(curr.size() == need) {
             chosen.add(new ArrayList(curr));
         }

         if(index >= n) return;

         if((state & (1 << index)) == 0) {
             //unselected, can be selected
             curr.add(index);
             getComb(need, curr, chosen, state, index+1, n);
             curr.remove(curr.size()-1);
         }

         //don't select
         getComb(need, curr, chosen, state, index+1, n);
    }
}


// class Solution {
//     int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
//     public int minimumMoves(int[][] grid) {
//         // Multisource BFS
//         Queue<int[]> q = new LinkedList(); //from x, from y, to X, to Y
        
//         for(int r = 0; r < grid.length; r++) {
//             for(int c = 0; c < grid[0].length; c++) {
//                 if(grid[r][c] == 0) q.add(new int[]{r, c, r, c});
//             }
//         }
        
//         int ans = 0, level = 0, noOfZ = q.size();
        
//         while(q.size() > 0 && noOfZ > 0) {
//             int len = q.size();
//             for(int i = 0; i < len; i++) {
//                 int[] curr = q.poll();
//                 if(grid[curr[2]][curr[3]] > 1 && grid[curr[0]][curr[1]] == 0) {
//                     grid[curr[0]][curr[1]] = 1;
//                     grid[curr[2]][curr[3]]--;
//                     ans += level;
//                     noOfZ--;
//                     continue;
//                 }
                
//                 for(int[] d : dir) {
//                     int r = curr[2]+d[0], c = curr[3]+d[1];
//                     if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) continue;
//                     q.add(new int[]{curr[0], curr[1], r, c});
                    
//                 }
//             }
//             level++;
//         }
        
//         return ans;
        
//     }
// }