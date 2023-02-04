// 485. Max Consecutive Ones

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cont = 0;

        for (int n : nums) {
            if (n == 1) {
                cont++;
            } else {
                cont = 0;
            }

            max = Math.max(cont, max);
        }
        return max;

    }
}