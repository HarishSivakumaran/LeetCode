// 441. Arranging Coins

class Solution {
    public int arrangeCoins(int n) {
      long left = 0, right = n;
      long k, curr, m = 0;
      while (left <= right) {
        k = left + (right - left) / 2;
        curr = k * (k + 1) / 2;
  
        if (curr == n) return (int)k;
  
        if (n < curr) {
          right = k - 1;
        } else {
          m=k;
          left = k + 1;
        }
      }
      return (int)m;
    }
  }