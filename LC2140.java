// 2140. Solving Questions With Brainpower

class Solution {
    Long[] cache;
    public long mostPoints(int[][] questions) {
        cache = new Long[questions.length];
        return getPoints(questions, 0);
    }

    public long getPoints(int[][] questions, int index){
        if(index >= questions.length) return 0;
        if(cache[index] != null) return cache[index];

        long val = Math.max(getPoints(questions, index+1),
         questions[index][0] + getPoints(questions, index+1+questions[index][1]));

        return cache[index] = val; 
    }
}