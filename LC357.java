// 357. Count Numbers with Unique Digits

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] nums = new int[n+1];
        nums[0]=1;
        for(int  i = 1; i <= n; i++){
            nums[i] = uniqueNDigitsNum(i)+nums[i-1];
        }

        return nums[n];

    }

    public int uniqueNDigitsNum(int n){
        
        int uniqueNums = 1;
        int totalDigits = 9; 

        for(int i = 0; i < n; i++){
            if(i>1){
                totalDigits--;
            }
            uniqueNums *= totalDigits;           
        }

        return uniqueNums;

    }
}