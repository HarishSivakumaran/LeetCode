// 207. Course Schedule



class Solution {
    boolean res = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        List<Integer> t;
        int i = 0;
        while(i < numCourses){
            t = new ArrayList<Integer>();
            hm.put(i, t);
            i++;
        }
        for(int[] p : prerequisites){
            hm.get(p[0]).add(p[1]);
            if(p[0] == p[1]) return false;
        } 

        for(i = 0 ; i < numCourses; i++){
            dfs(i, hm, hs);
            if(hm.get(i).size() != 0 ) return false;
        }   


        return true;

        
    }

    public boolean dfs(int n, HashMap<Integer, List<Integer>> hm,  HashSet<Integer> hs){
        if(hs.contains(n)){ //cyclic dependency
         return false;
        }

        hs.add(n);

        if(hm.get(n).size() == 0){
         hs.remove(n);
         return true;
        }

        List<Integer> l1 = new ArrayList<>();
        for(int i : hm.get(n)){
            boolean courseDoable = dfs(i, hm, hs);
            if(!courseDoable){
                 hs.remove(n);
                return false;
            }
        }
        hm.put(n, l1);
        hs.remove(n);

        return hm.get(n).size() == 0;
    }
}