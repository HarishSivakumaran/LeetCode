// 1964. Find the Longest Valid Obstacle Course at Each Position

class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] out = new int[obstacles.length];
        int[] sortedArr = new int[obstacles.length];
        for(int i = 0; i < obstacles.length; i++){
            out[i] = insertVal(sortedArr, obstacles[i]);
        }

        return out;
    }

    public int insertVal(int[] sortedArr, int val){
        int l = 0, r = sortedArr.length-1, m = 0;
        while (l <= r){
            m = l + (r-l)/2;
            if(sortedArr[m] > val){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        sortedArr[l] = val;
        return l+1;
    }
}s