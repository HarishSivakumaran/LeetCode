// 210. Course Schedule II

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) { 
        List<List<Integer>> allCourses = new ArrayList();   
        for(int i = 0; i < numCourses; i++){
            allCourses.add(new ArrayList<Integer>());
        }   

        for(int[] pre : prerequisites){
            allCourses.get(pre[0]).add(pre[1]);
        }  

        int[] out = {};
        List<Integer> oList = new ArrayList<>();
        boolean[] doable = new boolean[numCourses];
        HashSet<Integer> visited = new HashSet<>();
        for(int i = 0; i < numCourses; i++){
            if(!isCourseDoable(allCourses, i, doable, visited)) return out;
        } 

        visited = new HashSet<>();

         for(int i = 0; i < numCourses; i++){
            postOrder(allCourses, i, oList, visited);
        } 

        int[] array = new int[oList.size()]; int j = 0;

        for(int i : oList){
            array[j++] = i;
        }

        return array;
        
    }

    public void postOrder(List<List<Integer>> allCourses, int curr, List<Integer> out, HashSet<Integer> visited){

        if(visited.contains(curr)) return;

        visited.add(curr);

        for(int preReqCourse : allCourses.get(curr) ){
             postOrder(allCourses, preReqCourse, out, visited);     
        }
        out.add(curr);
    }

    public boolean isCourseDoable(List<List<Integer>> allCourses, int currCourse, boolean[] doable, HashSet<Integer> visited){

        if(visited.contains(currCourse)) return false;

        if(doable[currCourse]) return true;

        boolean canBeDone = true;

        visited.add(currCourse);

        for(int preReqCourse : allCourses.get(currCourse) ){
            canBeDone = canBeDone && isCourseDoable(allCourses, preReqCourse, doable, visited);     
            if(!canBeDone)  break;   
        }

        doable[currCourse] = canBeDone;

        visited.remove(currCourse);

        return doable[currCourse];

    }
}