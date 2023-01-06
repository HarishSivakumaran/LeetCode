// 1899. Merge Triplets to Form Target Triplet

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        //remove triplets that are bigger than target

        boolean[] p = new boolean[3];

        for(int[] t : triplets){
            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) continue;

            p[0] = p[0] ? p[0] : t[0] == target[0];
            p[1] = p[1] ? p[1] : t[1] == target[1];
            p[2] = p[2] ? p[2] : t[2] == target[2];    

            if(p[0] && p[1] && p[2])  return true;

        }

        return p[0] && p[1] && p[2];     
        
    }
}