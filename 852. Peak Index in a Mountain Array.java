class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length-1, m = 0, before = 0, after = 0;

        while(l <= r) {
            m = l + (r-l)/2;
             before = m-1 >= 0 ? arr[m-1] : -1;
             after = m+1 < arr.length ? arr[m+1] : Integer.MAX_VALUE;
            if(arr[m] > before && arr[m] > after){
                return m;
            }

            if(arr[m] > before){
                l = m+1;
            }

            else if (arr[m] > after){
                r = m-1;
            }
        }

        return -1;
    }
}