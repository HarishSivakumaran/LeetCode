// 287. Find the Duplicate Number

class Solution {
    public int findDuplicate(int[] nums) {
        int l = 1, h = nums.length-1, ans = 0;

        while(l <= h){
            int m = (int)(l + (h-l)/2);
            int c = 0;
            for(int n : nums){
                if(n <= m) c++;
            }

            if(c <= m){
                // less dense number -> have to increase the low value
                l = m+1;
            }else{
                // this number had more density
                ans = m;
                h = m-1;
            }

        }

        return ans;
        
    }
}