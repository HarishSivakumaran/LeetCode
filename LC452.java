// 452. Minimum Number of Arrows to Burst Balloons

class Solution {
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (a, b) -> a[0] - b[0]);

        int[] curr = null;
        int count = 0;

        for(int[] p : points){
            if(curr == null){
                curr = p;
                count++;
            }else{
                //check for overlap
                if( p[1] >= curr[0] && p[0] <= curr[1]){
                    curr[0] = Math.max(curr[0], p[0]);
                    curr[1] = Math.min(curr[1], p[1]);

                }else{
                    count++;
                    curr = p;
                }
            }
        }

        return count;


        
    }
}