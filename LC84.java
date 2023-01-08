// 84. Largest Rectangle in Histogram

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> s = new Stack<>();
        int max = -1;

        for(int i = 0; i < heights.length; i++){
            if(s.size() == 0){
                s.push(new int[]{i, heights[i]});
                continue;
            }

            int[] top = s.peek();
            if(heights[i] >= top[1]){
                s.push(new int[]{i, heights[i]});
            }else{
                while(s.size()>0 && s.peek()[1] >= heights[i]){
                    top = s.pop();     
                    max = Math.max(max, top[1] * (i - top[0]));  
                }
                s.push(new int[]{top[0], heights[i]}); 
            }
        }  

        while(s.size()>0){
            int[] top = s.pop();     
            max = Math.max(max, top[1] * (heights.length - top[0]));  
        } 
        return max;   
    }
}