// 663 · Walls and Gates

public class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public void wallsAndGates(int[][] rooms) {

        Queue<int[]> q = new LinkedList<>();
   
        for(int r = 0; r < rooms.length; r++){
            for(int c = 0; c < rooms[0].length; c++){
              if(rooms[r][c] == 0){
                q.add(new int[]{r,c});
              }
            }
        }


        int dist = -1;

        while(q.size() > 0){
            int len = q.size();
           
            dist++;

            for(int i = 0; i < len; i++){
                
                int[] currPoint = q.poll();

                for(int[] d : this.dir){
                    int[] nextPoint = new int[]{currPoint[0]+d[0], currPoint[1]+d[1]};
                    if(nextPoint[0] < 0 || nextPoint[0] >= rooms.length || nextPoint[1] < 0 || nextPoint[1] >= rooms[0].length || rooms[nextPoint[0]][nextPoint[1]] != Integer.MAX_VALUE ) continue;
                    rooms[nextPoint[0]][nextPoint[1]] = rooms[currPoint[0]][currPoint[1]] + 1;
                    q.add(nextPoint);
                }
            }

        }

        
    }

   

}