// 149. Max Points on a Line

class Solution {
    public int maxPoints(int[][] points) {

        if(points.length < 3) return points.length;

        int m = 2;

        for(int i = 0; i < points.length; i++){

            int[] curr = points[i];
            
            HashMap<Double, Integer> hm = new HashMap<>();

            for(int j = 0; j < points.length; j++){

                if(i == j) continue;

                int[] next = points[j];

                Double slope = Math.atan2(next[1]-curr[1], next[0]-curr[0]);

                hm.put(slope, hm.getOrDefault(slope, 1)+1);
                
                m = Math.max(m, hm.get(slope));

            }
            
        }  

        return m;           
    }
}