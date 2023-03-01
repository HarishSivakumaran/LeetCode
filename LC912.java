// 912. Sort an Array

class Solution {
    int[] arr;
    public int[] sortArray(int[] nums) {
        arr = nums;
        sort(0, nums.length-1);
        return arr;
    }


    public void sort(int l, int r){
        if(l >= r) return;
        int i = l, temp = 0, lInit = l;
        Random rand = new Random();
        int a = rand.nextInt(r-l)+l;
        
        temp = arr[r];
        arr[r] = arr[a];
        arr[a] = temp;

        while(l < r){
            if(arr[l] < arr[r]){
                temp = arr[i];
                arr[i++] = arr[l];
                arr[l] = temp;
            }
            l++;
        }
        temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;

        sort(lInit, i-1);
        sort(i+1, r);
    }
}