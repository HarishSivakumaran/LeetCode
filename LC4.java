// 4. Median of Two Sorted Arrays

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = m + n;
        int half = (total + 1) / 2;

        int left = 0;
        int right = m;

        var result = 0.0;

        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = half - i;

            // get the four points around possible median
            int left1 = (i > 0) ? nums1[i - 1] : Integer.MIN_VALUE;
            int right1 = (i < m) ? nums1[i] : Integer.MAX_VALUE;
            int left2 = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
            int right2 = (j < n) ? nums2[j] : Integer.MAX_VALUE;

            // partition is correct
            if (left1 <= right2 && left2 <= right1) {
                // even
                if (total % 2 == 0) {
                    result =
                        (Math.max(left1, left2) + Math.min(right1, right2)) /
                        2.0;
                    // odd
                } else {
                    result = Math.max(left1, left2);
                }
                break;
            }
            // partition is wrong (update left/right pointers)
            else if (left1 > right2) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }

        return result;


       
        // int[] aInd = getMedianIndices(nums1.length, nums2.length);
        
        // int[] aOut = new int[aInd[aInd.length-1]+1];
        
        // int num1Pointer = 0;
        // int num2Pointer = 0;
        // int outPointer = 0;

        
        // while(outPointer < (aInd[aInd.length-1] + 1) ){
        //     int currNums1 = num1Pointer > nums1.length-1? Integer.MAX_VALUE :  nums1[num1Pointer];
        //     int currNums2 = num2Pointer > nums2.length-1? Integer.MAX_VALUE :  nums2[num2Pointer];
        //     if( currNums1 < currNums2){
        //         aOut[outPointer] = currNums1;
        //         num1Pointer++;
        //         outPointer++;
        //     }else{
        //         aOut[outPointer] = currNums2;
        //         num2Pointer++;
        //         outPointer++;
        //     }
        // }
        
        // if(aInd.length == 2){
        //     return (double)( aOut[aInd[0]] + aOut[aInd[1]])/2;
        // }else{
        //     return (double)aOut[aInd[0]];
        // }

        
    }
    
    public int[] getMedianIndices(int m, int n){
        double dMidInd = (double)(m+n)/2;
        double dec =  dMidInd - (int)dMidInd;
        
        if(dec != 0){
            int[] ind = new int[]{(int)dMidInd};
            return ind;
        }else{
            int[] ind2 = new int[]{(int)dMidInd-1, (int)dMidInd};
            return ind2;
        }
        
    }
}