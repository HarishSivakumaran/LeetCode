// 909. Snakes and Ladders

class Solution {
    public int snakesAndLadders(int[][] board) {
        int nSq = board.length * board.length;
        boolean rev = false;
        int[] line = new int[nSq];
        int[] dist = new int[nSq];

        for(int i = board.length -1; i >=0; i--){
            if(rev){
                for(int j = board.length-1; j >= 0 ; j--){
                    line[(board.length-1 - i) * (board.length) + (board.length-1-j)] = board[i][j];
                }                
            }else{          
                for(int j = 0; j < board.length; j++){
                    line[(board.length-1 - i) * (board.length) +j] = board[i][j];
                }
            }

            rev = !rev;
        }


        PriorityQueue<int[]> pq = new PriorityQueue(new DistComparator());
        
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        pq.add(new int[]{dist[0], 0});
        HashSet<Integer> visited = new HashSet();

        while(pq.size() > 0){
            int len = pq.size();

            for(int i = 0; i < len; i++){
                int[] position = pq.poll();
                int cdist = position[0];
                int pos  = position[1];
                if(visited.contains(pos)) continue;
                visited.add(pos);
                int maxNext = Math.min(pos+6, nSq-1);
                for(int j = pos+1; j <= maxNext; j++){
                    if(line[j] > -1){
                        int jump = line[j]-1;
                        if(dist[jump] > 1 + cdist)
                        { 
                            dist[jump] = 1 + cdist;
                            pq.add(new int[]{dist[jump], jump});
                        }
                    }else{
                        if(dist[j] > 1 + cdist) dist[j] = 1 + cdist;
                        pq.add(new int[]{dist[j], j});
                    }
                }
            }
        }

        return dist[nSq-1] == Integer.MAX_VALUE ? -1 : dist[nSq-1];
    }

    class DistComparator implements Comparator<int[]>{
             
            // Overriding compare()method of Comparator
                        // for descending order of cgpa
            public int compare(int[] s1, int[] s2) {
                if (s1[0] != s2[0]) return s1[0]-s2[0];
                return s2[1]-s1[1];
                
        }
    }
}