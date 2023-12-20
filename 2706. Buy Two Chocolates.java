class Solution {
    public int buyChoco(int[] prices, int money) {
        int min = Integer.MAX_VALUE, secMin = Integer.MAX_VALUE;
        for(int p : prices) {
            if(p < min) {
                secMin = min;
                min = p;
            } else if (p < secMin) {
                secMin = p;
            }
        }

        return min + secMin > money ? money : money-(min+secMin);
    }
}