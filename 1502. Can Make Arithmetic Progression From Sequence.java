class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        Integer diff = null, curr = 0;
        for(int i = 0; i < arr.length-1; i++){
            curr = arr[i+1]-arr[i];
            if(diff == null){
                diff = curr;
            }

            if(!diff.equals(curr)){
                return false;
            }
        }

        return true;
    }
}