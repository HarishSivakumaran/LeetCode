1561. Maximum Number of Coins You Can Get
class Solution {
    public int maxCoins(int[] piles) {
        int ans = 0;
        Arrays.sort(piles);
        int l = 0, r = piles.length-1;
        while(l<r) {
            ans += piles[r-1];
            l++;
            r -= 2;
        }
        return ans;
    }
}