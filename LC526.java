// 526. Beautiful Arrangement

class Solution {
    Integer ans = 0;

    public int countArrangement(int n) {
        int[] num = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            num[i] = i;
        }

        checkBeautArrangement(num, 1);

        return this.ans;

    }

    public void checkBeautArrangement(int[] num, int s) {
        if (s >= num.length) {
            this.ans++;
            return;
        }

        for (int i = s; i < num.length; i++) {
            boolean isStartCorrect = (num[i] % s == 0) || (s % num[i] == 0);
            if (isStartCorrect) {
                swap(num, s, i);
                checkBeautArrangement(num, s + 1);
                swap(num, s, i);
            }
        }
    }

    public void swap(int[] num, int s, int i) {
        int temp = num[s];
        num[s] = num[i];
        num[i] = temp;
    }
}