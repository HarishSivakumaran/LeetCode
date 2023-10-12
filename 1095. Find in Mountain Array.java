/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
 class Solution {
    public int findInMountainArray(int target, MountainArray mount) {
        int l = 0, r = mount.length()-1, m = 0;
        int peakIndex = -1;

        while(l <= r) {
            m = l + (r-l)/2;
            int val = mount.get(m);
            int prev = m-1 >= 0 ? mount.get(m-1) : Integer.MIN_VALUE;
            
            if(val < prev) {
                //right side     
                r = m-1;
            } else {
                //left side        
                l = m+1;
            }
        }
        peakIndex = r;

        l = 0;

        while(l <= r) {
            m = l + (r-l)/2;
            int val = mount.get(m);
            if(val == target) return m;
            if(val < target) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        l = peakIndex+1;
        r = mount.length()-1;

        while(l <= r) {
            m = l + (r-l)/2;
            int val = mount.get(m);
            if(val == target) return m;
            if(val < target) {
                r = m-1;
            } else {
                l = m+1;
            }
        }

        return -1;
    }
}